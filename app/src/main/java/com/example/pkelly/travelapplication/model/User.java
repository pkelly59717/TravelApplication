package com.example.pkelly.travelapplication.model;

/*
Created by Paul Kelly
Matriculation Number:40282331
SOC10101 Honours Project
2017-2018
*/

public class User {

    //variables
    private int id;
    private String name;
    private String email;
    private String password;

    //getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
