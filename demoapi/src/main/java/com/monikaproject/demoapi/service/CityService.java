package com.monikaproject.demoapi.service;
import com.monikaproject.demoapi.repository.CityRepository;
import com.monikaproject.demoapi.entity.City;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService {
    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {

        List<City> cities = (List<City>) repository.findAll();

        return cities;
    }

    @Override
    public Optional<City> findById(Long id) {

        Optional<City> city = repository.findById(id);
        return city;
    }

    @Override
    public void deleteCity(Long id) {
        repository.deleteById(id);
    }

    @Override
    public City add(City city) {
        City toAdd = new City();
        toAdd.setName(city.getName());
        toAdd.setPopulation(city.getPopulation());
        City savedCity = repository.save(toAdd);
        return savedCity;

    }
}

