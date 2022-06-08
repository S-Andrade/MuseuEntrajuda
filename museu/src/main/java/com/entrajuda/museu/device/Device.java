package com.entrajuda.museu.device;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

    public Device(String name, String description, String model, String brand){
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.description = description;
    }

    public Device(Integer device_id, String name, String description,String model, String brand){
        this.device_id = device_id;
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.description = description;
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

}