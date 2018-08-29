package com.springboot.model;

import javax.persistence.*;

@Entity
public class Classs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "person_id")
    private int personId;
}
