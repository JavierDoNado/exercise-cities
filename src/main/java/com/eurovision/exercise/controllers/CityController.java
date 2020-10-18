package com.eurovision.exercise.controllers;

import com.eurovision.exercise.dto.CitiesResponse;
import com.eurovision.exercise.dto.CityDTO;
import com.eurovision.exercise.services.CitiesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/cities"})
public class CityController {

    @Autowired
    CitiesService citiesService;

    @RequestMapping(method = {RequestMethod.GET}, produces = {"application/json"})
    @CrossOrigin(origins = "${cors.allowed.origins}")
    @ApiOperation(value = "get-page-cities", httpMethod = "GET", nickname = "get-page-cities")
    public Page<CityDTO> getCities(@RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "10") int size) {
        CitiesResponse response = citiesService.getCities(page, size);
        return new PageImpl<>(response.getListCities(), response.getPageRequest(), response.getTotalElements());

    }
}