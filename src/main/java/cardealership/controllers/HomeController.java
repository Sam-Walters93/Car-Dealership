package cardealership.controllers;

import cardealership.models.Special;
import cardealership.models.Vehicle;
import cardealership.repositories.SpecialRepository;
import cardealership.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    VehicleRepository vehicleRepo;
    SpecialRepository specialRepo;

    @Autowired
    public HomeController(VehicleRepository vehicleRepo, SpecialRepository specialRepo) {
        this.vehicleRepo = vehicleRepo;
        this.specialRepo = specialRepo;
    }

    @GetMapping
    public String showFeaturedVehicles(Model model) {
        // get only featured vehicles
        List<Vehicle> vehicles = vehicleRepo.findAll().stream().filter(x -> !x.isSold()).filter(Vehicle::isFeature).toList();
        model.addAttribute("vehicles", vehicles);
        return "home/index";
    }

    @GetMapping("/specials")
    public String showSpecials(Model model) {
        List<Special> specials = specialRepo.findAll();
        model.addAttribute("specials", specials);
        return "home/special";
    }

    @GetMapping("/contact")
    public String showContact() {
        return "home/contact";
    }
}
