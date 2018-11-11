package com.chen.entity;

public class City {
    private int region_id;

    private String region_name;

    private int parent_id;

    public City() {
    }

    public City(int region_id, String region_name, int parent_id) {
        this.region_id = region_id;
        this.region_name = region_name;
        this.parent_id = parent_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    @Override
    public String toString() {
        return "City{" +
                "region_id=" + region_id +
                ", region_name='" + region_name + '\'' +
                ", parent_id=" + parent_id +
                '}';
    }
}
