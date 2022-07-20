/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardealership.controllers;

import cardealership.models.Vehicle;
import cardealership.repositories.VehicleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author stwal
 */
@RestController
public class restController {
    @Autowired
    VehicleRepository vRepo;
    
    @GetMapping("/vehicleInfo")
    public List<Vehicle> getAllVehicles(){
        return vRepo.findAll();
    }
    
    
}
