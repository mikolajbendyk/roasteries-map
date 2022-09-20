package com.bendyk.roasteriesmap.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bendyk.roasteriesmap.model.City;
import com.bendyk.roasteriesmap.repository.CityRepository;

@Service
public class CityService {
    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Transactional
    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    @Transactional
    public City findCityById(int id) {
        return cityRepository.findCityById(id);
    }

    @Transactional
    public City findCityByName(String name) {
        return cityRepository.findCityByName(name);
    }

    @Transactional
    public void addCity(City city) {
        cityRepository.save(city);
    }

    @Transactional
    public void modifyCityName(City city) {
        if (city.getId() == 0) {
            // throw sth about missing id
        }
        if (checkCityExistsById(city.getId())) {
            findCityById(city.getId()).setName(city.getName());
        } else {
            //throw sth about city not found
        }
    }

    @Transactional
    public void deleteCityById(int id) {
        cityRepository.deleteById(id);
    }

    @Transactional
    public void deleteCityByName(String name) {
        cityRepository.deleteCityByName(name);
    }

    @Transactional
    public boolean checkCityExistsById(int id) {
        return cityRepository.existsById(id);
    }

    @Transactional
    public boolean checkCityExistsByName(String name) {
        return cityRepository.existsByName(name);
    }

    private void validateCityNameDuplication(String name) {
        if (checkCityExistsByName(name)) {
            // throw sth about city duplication
        }
    }
}
