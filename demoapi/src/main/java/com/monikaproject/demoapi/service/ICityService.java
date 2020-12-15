package com.monikaproject.demoapi.service;
import com.monikaproject.demoapi.entity.City;
import java.util.List;
import java.util.Optional;

public interface ICityService {

    public List<City> findAll();

    public Optional<City> findById(Long id);

    void deleteCity(Long id);

    public City add(City city);

    List<City> findAllOrderByPopulationAsc();

    List<City> findAllOrderByNameAsc();
}
