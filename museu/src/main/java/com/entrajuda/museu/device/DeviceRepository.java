package com.entrajuda.museu.device;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



public interface DeviceRepository extends JpaRepository<Device, Integer>, JpaSpecificationExecutor<Device> {    
    
}