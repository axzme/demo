package com.springboot.model;


import javax.validation.constraints.Pattern;

public class ZhengZeTestBean {
    @Pattern(regexp = "^[a-z0-9A-Z_\\u1000-\\u109F]{1,20}$",message = "error")
    private String name;

    private Integer tes;

    public Integer getTes() {
        return tes;
    }

    public void setTes(Integer tes) {
        this.tes = tes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
