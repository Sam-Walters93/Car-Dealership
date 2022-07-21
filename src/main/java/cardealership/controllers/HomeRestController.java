package cardealership.controllers;

import cardealership.models.Special;
import cardealership.models.Vehicle;
import cardealership.repositories.SpecialRepository;
import cardealership.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeRestController {

    VehicleRepository vehicleRepo;
    SpecialRepository specialRepo;

    @Autowired
    public HomeRestController(VehicleRepository vehicleRepo, SpecialRepository specialRepo) {
        this.vehicleRepo = vehicleRepo;
        this.specialRepo = specialRepo;
    }

    @GetMapping("/index")
    public List<Vehicle> showFeaturedVehicles() {
        // get only featured vehicles
        return vehicleRepo.findAll().stream().filter(x -> !x.isSold()).filter(Vehicle::isFeature).toList();
    }

    @GetMapping("/specials")
    public List<Special> showSpecials() {
        return specialRepo.findAll();
    }

    @GetMapping("/contact")
    public String showContact() {
        return "home/contact";
    }
}
