package com.example.demo.mapper;

import com.example.demo.model.Region;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@MybatisTest
class RegionMapperTest {

    @Autowired
    private RegionMapper regionMapper;

    @Test
    void getByName() {
        List<Region> regions = regionMapper.findAll();
        assertFalse(regions.isEmpty());
    }

}