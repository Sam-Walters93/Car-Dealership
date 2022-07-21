package cardealership.restControllers;

import cardealership.models.Purchase;
import cardealership.models.Vehicle;
import cardealership.repositories.PurchaseRepository;
import cardealership.repositories.StateRepository;
import cardealership.repositories.VehicleRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesRestController {

    VehicleRepository vehicleRepo;
    PurchaseRepository purchaseRepo;
    StateRepository stateRepo;

    public SalesRestController(VehicleRepository vehicleRepo, PurchaseRepository purchaseRepo, StateRepository stateRepo) {
        this.vehicleRepo = vehicleRepo;
        this.purchaseRepo = purchaseRepo;
        this.stateRepo = stateRepo;
    }

    @GetMapping("/index")
    public List<Vehicle> showOnSaleVehicles() {
        return vehicleRepo.findAll().stream().filter(x -> !x.isSold()).toList();
    }


    // ********************************************
    // get all states
//                    stateRepo.findAll();
    // ********************************************


    @PostMapping("/purchase/{id}")
    public void makePurchasedVehicles(@PathVariable int id, Purchase purchase) {
        // set purchased date
        Date today = Date.valueOf(LocalDate.now());
        purchase.setPurchaseDate(today);

        vehicleRepo
                .findById(id)
                .ifPresent(vehicle -> {
                    // set vehicle sold and save if it exists
                    vehicle.setSold(true);
                    vehicleRepo.save(vehicle);
                    // save purchase as well
                    purchaseRepo.save(purchase);
                });
    }
}
