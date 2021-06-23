package com.example.demo.model;

public class Region {
    private Integer id;
    private String name;
    private String shortname;

    public Region() {
    }

    public Region(Integer id, String name, String short_name) {
        this.id = id;
        this.name = name;
        this.shortname = short_name;
    }

    public Region(String name, String short_name) {
        this.name = name;
        this.shortname = short_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name() {
        return shortname;
    }

    public void setShort_name(String short_name) {
        this.shortname = short_name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", short_name='" + shortname + '\'' +
                '}';
    }
}
