package com.monikaproject.demoapi.controller;
import com.monikaproject.demoapi.entity.City;

import java.util.List;
import java.util.Optional;

import com.monikaproject.demoapi.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Mycontroller {
    @Autowired
    ICityService cityService;

    @RequestMapping("/cities")
    public List<City> findCities() {

        List<City> cities = (List<City>) cityService.findAll();
        return cities;
    }

    @RequestMapping("/cities/{id}")
    public Optional<City> findCity(@PathVariable Long id) {

        Optional<City> city = cityService.findById(id);
        return city;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cities/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public City addCity(@RequestBody City city) {
        return cityService.add(city);
    }

    @GetMapping(value = "/population")
    public List<City> getCitiesByPopulation() {

        return cityService.findAllOrderByPopulationAsc();
    }

    @GetMapping(value = "/ascending")
    public List<City> getCitiesByNameAsc() {

        return cityService.findAllOrderByNameAsc();
    }

    @GetMapping(value = "/descending")
    public List<City> getCitiesByNameDesc() {

        return cityService.findAllOrderByNameDesc();
    }

    @RequestMapping("/{population}")
    public Optional<City> findCityByPopulation(@PathVariable int population) {

        Optional<City> city = cityService.findByPopulation(population);
        return city;
    }


}