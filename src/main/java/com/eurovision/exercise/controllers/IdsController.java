package com.eurovision.exercise.controllers;


import com.eurovision.exercise.services.CitiesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SortedSet;

@RestController
@RequestMapping({"/ids"})
public class IdsController {

    @Autowired
    CitiesService citiesService;

    @RequestMapping(method = {RequestMethod.GET}, produces = {"application/json"})
    @ApiOperation(value = "get-page-cities", httpMethod = "GET", nickname = "get-page-cities")
    public ResponseEntity getCities(@RequestParam(name = "Limit of results (N)", defaultValue = "10") int page,
                                    @RequestParam(name = "Number of cities to search", defaultValue = "100") int size) {
        List<Integer> response = citiesService.getBiggestSequence(page, size);
        return ResponseEntity.ok(response);
    }
}

