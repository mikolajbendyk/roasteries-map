package com.bendyk.roasteriesmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bendyk.roasteriesmap.model.City;

public interface CityRepository extends JpaRepository<City, Integer> {
    City findCityById(int id);
    City findCityByName(String name);
    void deleteCityByName(String name);
    boolean existsByName(String name);
}
