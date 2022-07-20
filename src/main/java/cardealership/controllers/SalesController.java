package cardealership.controllers;

import cardealership.models.Purchase;
import cardealership.models.State;
import cardealership.models.Vehicle;
import cardealership.repositories.PurchaseRepository;
import cardealership.repositories.StateRepository;
import cardealership.repositories.VehicleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/sales")
public class SalesController {

    VehicleRepository vehicleRepo;
    PurchaseRepository purchaseRepo;
    StateRepository stateRepo;

//    @GetMapping("/index")
//    public String showOnSaleVehicles(Model model) {
//        List<Vehicle> vehicles = vehicleRepo.findAll().stream().filter(x -> !x.isSold()).toList();
//        model.addAttribute("vehicles", vehicles);
//        return "sales/index";
//    }

    @GetMapping("/purchase")
    public String showPurchasedVehicles(Integer id, Model model) {
        Vehicle vehicle = vehicleRepo.findById(id).orElse(null);
        List<State> states = stateRepo.findAll();

        model.addAttribute("vehicle", vehicle);
        model.addAttribute("purchase", new Purchase());
        model.addAttribute("states", states);
        return "sales/purchase";
    }

    @PostMapping("/purchase")
    public String makePurchasedVehicles(Purchase purchase, Integer id) {
        // set purchased date
        Date today = Date.valueOf(LocalDate.now());
        purchase.setPurchaseDate(today);

        // set vehicle sold and save if it exists
        // save purchase as well
        vehicleRepo
                .findById(id)
                .ifPresent(vehicle -> {
                    vehicle.setSold(true);
                    vehicleRepo.save(vehicle);
                    purchaseRepo.save(purchase);
                });

        return "sales/purchase";
    }
}
