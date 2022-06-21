package com.entrajuda.museu.device;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entrajuda.museu.specifications.SearchCriteria;
import com.entrajuda.museu.specifications.SearchOperation;
import com.entrajuda.museu.user.User;
import com.entrajuda.museu.user.UserRepository;




@RestController
@RequestMapping(path="/device")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public Iterable<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

     
    @PostMapping(path="/add")
    public @ResponseBody String addNewDevice(
            @RequestParam String name, 
            @RequestParam String model, 
            @RequestParam String brand, 
            @RequestParam String description, 
            @RequestParam String localization, 
            @RequestParam Integer year,
            @RequestParam Integer user_id){

        User user;
        try {
            Optional<User> op_user = userRepository.findById(user_id);
            user = op_user.get();
            
        } catch (Exception e) {
            return null;
        }

        

        Device newDevice = new Device(name, description, model, brand, localization, year, user);
        deviceRepository.save(newDevice);
        
        return "Saved";
    }


    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteDeviceById(@RequestParam Integer device_id){
        deviceRepository.deleteById(device_id);
        return "Deleted";
    }


    @GetMapping(path="/{device_id}")
    public @ResponseBody Optional<Device> getDeviceById(@PathVariable Integer device_id){       
        return deviceRepository.findById(device_id);
    }


    @GetMapping(path="/filter")
    public @ResponseBody Iterable<Device> getAllProductsByFilter(
            @RequestParam(required=false) String name, 
            @RequestParam(required=false) String model, 
            @RequestParam(required=false) String brand, 
            @RequestParam(required=false) String description, 
            @RequestParam(required=false) String localization, 
            @RequestParam(required=false) Integer year,
            @RequestParam(required=false) Integer before_year,
            @RequestParam(required=false) Integer after_year,
            @RequestParam(required=false) String user_name){
        
        DeviceSpecification filter = new DeviceSpecification();
        if(name != null){
            filter.add(new SearchCriteria("name",name, SearchOperation.MATCH));
        }
        if(model != null){
            filter.add(new SearchCriteria("model",model, SearchOperation.MATCH));
        }
        if(brand != null){
            filter.add(new SearchCriteria("brand",brand, SearchOperation.MATCH));
        }
        if(description != null){
            filter.add(new SearchCriteria("description",description, SearchOperation.MATCH));
        }
        if(localization != null){
            filter.add(new SearchCriteria("localization",localization, SearchOperation.MATCH));
        }
        if(year != null){
            filter.add(new SearchCriteria("year",year, SearchOperation.EQUAL));
        }
        if(before_year != null){
            filter.add(new SearchCriteria("year", before_year, SearchOperation.LESS_THAN_EQUAL));
        }
        if(after_year != null){
            filter.add(new SearchCriteria("year", after_year, SearchOperation.GREATER_THAN_EQUAL));
        }
        if(user_name != null){  
            filter.add(new SearchCriteria("user_name", user_name, SearchOperation.MATCH));
        }
        
        return deviceRepository.findAll(filter);
    }


}