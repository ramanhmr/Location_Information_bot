package com.example.restmysql.controller;

import com.example.restmysql.model.City;
import com.example.restmysql.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/city_info")
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("")
    public List<City> list() {
        return cityService.listAllCities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> get(@PathVariable Integer id) {
        try {
            City city = cityService.getCity(id);
            return new ResponseEntity<City>(city, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<City> get(@PathVariable String name) {
        try {
            City city = cityService.getCity(name);
            return new ResponseEntity<City>(city, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody City city, @PathVariable Integer id) {
        try {
            City existCity = cityService.getCity(id);
            city.setId(id);
            cityService.saveCity(city);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/name/{name}")
    public ResponseEntity<?> update(@RequestBody City city, @PathVariable String name) {
        try {
            Integer id = cityService.getCity(name).getId();
            City existCity = cityService.getCity(name);
            city.setId(id);
            cityService.saveCity(city);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cityService.deleteCity(id);
    }

    @DeleteMapping("/name/{name}")
    public void delete(@PathVariable String name) {
        cityService.deleteCity(name);
    }
}
