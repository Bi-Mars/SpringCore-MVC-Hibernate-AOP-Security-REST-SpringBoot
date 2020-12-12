package com.bimarsh.reactspringcombo.reactspring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="add")
public class Add {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="a")
    private int a;

    @Column(name="b")
    private int b;

    public Add() {}

    public Add(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
