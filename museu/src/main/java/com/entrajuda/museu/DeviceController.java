package com.entrajuda.museu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/all")
    public Iterable<Device> getAllDevices() {
        return deviceRepository.findAll();
    }
}