package com.entrajuda.museu.device;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;



public interface DeviceRepository extends JpaRepository<Device, Integer>, JpaSpecificationExecutor<Device> {    
    
    @Query(value = "SELECT device_id FROM device ORDER BY counter DESC LIMIT 3", nativeQuery = true)
    Iterable<Object> findTopViewed();


}