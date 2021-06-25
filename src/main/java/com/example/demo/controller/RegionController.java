package com.example.demo.controller;

import com.example.demo.exception.ApiRequestException;
import com.example.demo.model.Region;
import com.example.demo.mapper.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/region")
public class RegionController {

    private final RegionMapper regionMapper;

    @Autowired
    public RegionController(RegionMapper regionMapper){
        this.regionMapper = regionMapper;
    }

    //Getting all regions from database
    @GetMapping(path = "/all")
    ResponseEntity<List<Region>> getRegions(){
    List<Region> regions = regionMapper.findAll();
        if (regions.isEmpty()){
            throw new ApiRequestException("No regions in the database");
        }
        else {
            return new ResponseEntity<>(
                    regions, HttpStatus.OK);
        }

    }

    //Add new region to database
    @GetMapping(path = "/new")
    ResponseEntity<String> newRegion(@RequestParam("region") String region, @RequestParam("shrt") String shrt){
        if (regionMapper.getByName(region).isPresent()){
            throw new ApiRequestException("This region is already in the database");
        }
        else {
            Region newregion = new Region();
            newregion.setName(region);
            newregion.setShort_name(shrt);
            regionMapper.insert(newregion);
            return new ResponseEntity<>("New region added", HttpStatus.OK);
        }
    }

    //Delete region by id
    @CacheEvict(cacheNames = "regions", key = "#id")
    @DeleteMapping(path = "/delete/{id}")
    ResponseEntity<String> deleteRegion(@PathVariable(value="id") Integer id){
    Optional<Region> requiredRegion = regionMapper.getById(id);
        if (requiredRegion.isEmpty()) {
            throw new ApiRequestException("No regions with this id exists in database");
        } else {
            regionMapper.deleteById(id);
            return new ResponseEntity<>("Region deleted", HttpStatus.OK);
        }
    }

    //Get region by id
    @Cacheable(cacheNames = "regions", key = "#id")
    @GetMapping(path = "/get/{id}")
    ResponseEntity<Region> getRegion(@PathVariable(value="id") Integer id){
        Optional<Region> requiredRegion = regionMapper.getById(id);
        if (requiredRegion.isEmpty()) {
            return null;
        } else {
            return new ResponseEntity<>(requiredRegion.get(), HttpStatus.OK);
        }
    }

    //Update region by id
    @Cacheable(cacheNames = "regions", key = "#id")
    @GetMapping(path = "/update/{id}")
    ResponseEntity<String> updateRegion(@PathVariable(value="id") Integer id, @RequestParam("region") String region, @RequestParam("shrt") String shrt){
        Optional<Region> requiredRegion = regionMapper.getById(id);
        if (requiredRegion.isEmpty()) {
            throw new ApiRequestException("No regions with this id exist in database");
        } else {
            regionMapper.updateById(id, region, shrt);
            return new ResponseEntity<>("Region updated", HttpStatus.OK);
        }
    }
}
