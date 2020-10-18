package com.eurovision.exercise.repositories;

import com.eurovision.exercise.beans.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository extends PagingAndSortingRepository<City, Integer> {
}
