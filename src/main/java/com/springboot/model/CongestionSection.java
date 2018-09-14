package com.springboot.model;

public class CongestionSection {

    private int congestion_distance;

    private float speed;

    private byte status;

    private String congection_trend;

    private String section_desc;

    public int getCongestion_distance() {
        return congestion_distance;
    }

    public void setCongestion_distance(int congestion_distance) {
        this.congestion_distance = congestion_distance;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getCongection_trend() {
        return congection_trend;
    }

    public void setCongection_trend(String congection_trend) {
        this.congection_trend = congection_trend;
    }

    public String getSection_desc() {
        return section_desc;
    }

    public void setSection_desc(String section_desc) {
        this.section_desc = section_desc;
    }
}
