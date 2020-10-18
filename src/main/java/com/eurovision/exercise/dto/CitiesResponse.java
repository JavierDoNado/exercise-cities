package com.eurovision.exercise.dto;

import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Object dedicated to give information to compose the page
 */
public class CitiesResponse {

    private PageRequest pageRequest;
    private List<CityDTO> listCities;
    private Long totalElements;

    /**
     * Constructor
     * @param pageRequest
     * @param listCities
     * @param totalElements
     */
    public CitiesResponse(PageRequest pageRequest, List<CityDTO> listCities, Long totalElements) {
        this.pageRequest = pageRequest;
        this.listCities = listCities;
        this.totalElements = totalElements;
    }

    /**
     *
     * @return PageRequest
     */
    public PageRequest getPageRequest() {
        return pageRequest;
    }

    /**
     * @param pageRequest
     */
    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    /**
     *
     * @return List<CityDTO>
     */
    public List<CityDTO> getListCities() {
        return listCities;
    }

    /**
     *
     * @param listCities
     */
    public void setListCities(List<CityDTO> listCities) {
        this.listCities = listCities;
    }

    /**
     *
     * @return Long
     */
    public Long getTotalElements() {
        return totalElements;
    }

    /**
     *
     * @param totalElements
     */
    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }
}
