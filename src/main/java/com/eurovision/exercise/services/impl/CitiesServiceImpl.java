package com.eurovision.exercise.services.impl;

import com.eurovision.exercise.beans.City;
import com.eurovision.exercise.dto.CitiesResponse;
import com.eurovision.exercise.dto.CityDTO;
import com.eurovision.exercise.repositories.CitiesRepository;
import com.eurovision.exercise.services.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementation of the Interface CitiesService
 */
@Service
public class CitiesServiceImpl implements CitiesService {

    @Autowired
    CitiesRepository citiesRepository;

    /**
     * Given a page and a size, the method returns an object (CitiesResponse), with information to compose a page
     * @param page
     * @param size
     * @return CitiesResponse
     */
    @Override
    public CitiesResponse getCities(Integer page, Integer size) {
        List<CityDTO> response = new ArrayList<>();
        PageRequest pageReq = PageRequest.of(page, size);
        Page<City> result = citiesRepository.findAll(pageReq);
        for(City city : result.getContent()){
            response.add(new CityDTO(city.getId(), city.getName()));
        }
        CitiesResponse citiesResponse = new CitiesResponse(pageReq, response, result.getTotalElements());
        return citiesResponse;
    }

    /**
     * First, get the k elements of table cities order alphabetically, then return N elements of k in order of ID
     * @param limit N elements to return
     * @param numberOfCities k elements to get from cities table
     * @return
     */
    @Override
    public List<Integer> getBiggestSequence(Integer limit, Integer numberOfCities) {
        //we get the first k (number of cities) order alphabetically
        PageRequest pageReq = PageRequest.of(0, numberOfCities);
        Page<City> result = citiesRepository.findAll(pageReq);
        List <City> listById  = result.toList();
        SortedSet<Integer> ids =new TreeSet();
        for(City city : listById){
            ids.add(city.getId());
        }
        //We get the first k (limit) elements
        return ids.stream().limit(limit).collect(Collectors.toList());
    }
}
