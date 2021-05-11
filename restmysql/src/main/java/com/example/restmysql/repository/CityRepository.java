package com.example.restmysql.repository;

import com.example.restmysql.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {
    Optional<City> findByName(String name);

    Optional<City> deleteByName(String name);
}
