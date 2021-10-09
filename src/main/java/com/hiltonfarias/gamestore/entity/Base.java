package com.hiltonfarias.gamestore.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Base {

    @Id
    @GeneratedValue
    public Long id;
}
