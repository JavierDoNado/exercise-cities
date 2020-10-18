package com.eurovision.exercise.dto;

/**
 * Object to exchange information of the cities
 */
public class CityDTO {

    private final String name;
    private final Integer id;

    /**
     *
     * @param id
     * @param name
     */
    public CityDTO(Integer id, String name) {
        this.name = name;
        this.id = id;
    }

    /**
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return Integer
     */
    public Integer getId() {
        return id;
    }

}
