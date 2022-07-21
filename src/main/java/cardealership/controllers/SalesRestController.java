package cardealership.controllers;

import cardealership.models.Purchase;
import cardealership.models.Vehicle;
import cardealership.repositories.PurchaseRepository;
import cardealership.repositories.StateRepository;
import cardealership.repositories.VehicleRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesRestController {

    VehicleRepository vehicleRepo;
    PurchaseRepository purchaseRepo;

    @GetMapping("/index")
    public List<Vehicle> showOnSaleVehicles() {
        return vehicleRepo.findAll().stream().filter(x -> !x.isSold()).toList();
    }

    @PostMapping("/purchase/{id}")
    public void makePurchasedVehicles(@PathVariable int id, Purchase purchase) {
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
    }
}
