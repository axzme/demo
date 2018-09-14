package com.springboot.model;

import java.util.List;

public class RoadTraffic {
    private String road_name;

    private List<CongestionSection> congestion_sections;

    public String getRoad_name() {
        return road_name;
    }

    public void setRoad_name(String road_name) {
        this.road_name = road_name;
    }

    public List<CongestionSection> getCongestion_sections() {
        return congestion_sections;
    }

    public void setCongestion_sections(List<CongestionSection> congestion_sections) {
        this.congestion_sections = congestion_sections;
    }
}
