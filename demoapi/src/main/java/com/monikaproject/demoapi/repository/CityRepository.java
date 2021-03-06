package com.monikaproject.demoapi.repository;
import com.monikaproject.demoapi.entity.City;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("FROM City ORDER BY population ASC")
    List<City> findAllOrderByPopulationAsc();

    @Query("FROM City ORDER BY name ASC")
    List<City> findAllOrderByNameAsc();

    @Query("FROM City ORDER BY name DESC")
    List<City> findAllOrderByNameDesc();


    Optional<City> findByPopulation(int population);
}
