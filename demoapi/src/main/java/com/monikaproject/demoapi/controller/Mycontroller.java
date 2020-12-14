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
    @RequestMapping(method = RequestMethod.POST,value = "/cities")
       public void addCity(@RequestBody City city) {
        cityService.addCity(city);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/cities/{id}")
    public void updateCity(@RequestBody City city,@PathVariable Long id) {
        cityService.updateCity(city,id);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/cities/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }

}

