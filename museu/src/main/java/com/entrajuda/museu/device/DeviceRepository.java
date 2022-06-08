package com.entrajuda.museu.device;


import org.springframework.data.jpa.repository.JpaRepository;


public interface DeviceRepository extends JpaRepository<Device, Integer> {    
    Device findByName(String name);
    
}