package com.springboot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;


@ApiModel(value = "class")
@Table(name = "class")
public class Classs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "id",value = "id")
    private Integer id;

    @ApiModelProperty(name = "name",value = "姓名")
    private String name;

    @ApiModelProperty(name = "personId",value = "personId")
    @Column(name = "person_id")
    private int personId;

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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
