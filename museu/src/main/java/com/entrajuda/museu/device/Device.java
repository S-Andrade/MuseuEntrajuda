package com.entrajuda.museu.device;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.entrajuda.museu.user.User;

@Entity
@Table(name="device")
public class Device {
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="device_id")
    private Integer device_id;

    @Column(name="name")
    private String name;

    @Column(name="model")
    private String model;

    @Column(name="brand")
    private String brand;

    @Column(name="description")
    private String description;

    @Column(name="localization")
    private String localization;
    
    @Column(name="year")
    private Integer year;

    @Column(name="counter")
    private Integer counter;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name="user_name")
    private String user_name;


    public Device(){}

    public Device(String name, String description, String model, String brand, String localization, Integer year,User user){
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.description = description;
        this.localization = localization;
        this.year = year;
        this.counter = 0;
        this.user = user;
        this.user_name = user.getName();
    }

    public Device(Integer device_id, String name, String description,String model, String brand, String localization, Integer year, User user){
        this.device_id = device_id;
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.description = description;
        this.localization = localization;
        this.year = year;
        this.counter = 0;
        this.user = user;
        this.user_name = user.getName();
    }

    public Integer getDevide_Id(){
        return device_id;
    }

    public void setDevice_Id(Integer device_id){
        this.device_id = device_id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model=model;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand=brand;
    }

    public String getLocalization(){
        return localization;
    }

    public void setLocalization(String localization){
        this.localization = localization;
    }

    public Integer getYear(){
        return year;
    }

    public void setYear(Integer year){
        this.year = year;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Integer getCounter(){
        return counter;
    }

    public void setCounter(Integer counter){
        this.counter = counter;
    }

    public String getUser_name(){
        return user_name;
    }

    public void setUser_name(String user_name){
        this.user_name=user_name;
    }

}