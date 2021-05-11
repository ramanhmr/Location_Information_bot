package com.example.restmysql.service;

import com.example.restmysql.model.City;
import com.example.restmysql.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> listAllCities() {
        return cityRepository.findAll();
    }

    public void saveCity(City city) {
        cityRepository.save(city);
    }

    public City getCity(Integer id) {
        return cityRepository.findById(id).get();
    }

    public City getCity(String name) {
        return cityRepository.findByName(name).get();
    }

    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
    }

    public void deleteCity(String name) {
        cityRepository.deleteByName(name);
    }
}
