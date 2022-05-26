package com.entrajuda.museu;


import org.springframework.data.jpa.repository.JpaRepository;


public interface DeviceRepository extends JpaRepository<Device, Long> {

    Device findByName(String name);
    
}