package com.eurovision.exercise.services;

import com.eurovision.exercise.dto.CitiesResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CitiesService {

    CitiesResponse getCities(Integer page, Integer size);
    List<Integer> getBiggestSequence(Integer limit, Integer numberOfCities);
}
