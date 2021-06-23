package com.example.demo.mapper;

import com.example.demo.model.Region;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface RegionMapper {

    @Select("select * from region")
    List<Region> findAll();

    @Insert("insert into region(name,shortname) values(#{name},#{shortname})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(Region region);

    @Delete("delete from region where id = #{id};")
    void deleteById(Integer id);

    @Select("select * from region where id = #{id};")
    Optional<Region> getById(Integer id);

    @Select("select * from region where name = #{name};")
    Optional<Region> getByName(String name);
}
