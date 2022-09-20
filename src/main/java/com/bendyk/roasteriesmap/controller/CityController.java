package com.bendyk.roasteriesmap.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bendyk.roasteriesmap.model.City;
import com.bendyk.roasteriesmap.service.CityService;

@RestController
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public List<City> findCities() {
        return cityService.findAllCities();
    }

    @GetMapping("/cities/id/{id}")
    public City findCityById(@PathVariable int id) {
        return cityService.findCityById(id);
    }

    @GetMapping("/cities/name/{name}")
    public City findCityByName(@PathVariable String name) {
        return cityService.findCityByName(name);
    }

    @GetMapping("/cities/exists/id/{id}")
    public boolean checkCityExistsById(@PathVariable int id) {
        return cityService.checkCityExistsById(id);
    }

    @GetMapping("/cities/exists/name/{name}")
    public boolean checkCityExistsByName(@PathVariable String name) {
        return cityService.checkCityExistsByName(name);
    }

    @PostMapping("/cities")
    public void addCity(@RequestBody @Valid City city) {
        cityService.addCity(city);
    }

    @PutMapping("/cities")
    public void modifyCity(@RequestBody @Valid City city) {
        cityService.modifyCityName(city);
    }

    @DeleteMapping("/cities")
    public void deleteCity(@RequestParam(required = false) Integer id, @RequestParam(required = false) String name) {
        if (id != null) {
            cityService.deleteCityById(id);
        } else if (StringUtils.isNotBlank(name)) {
            cityService.deleteCityByName(name);
        } else {
            //throw sth about missing identifier
        }
    }
}
