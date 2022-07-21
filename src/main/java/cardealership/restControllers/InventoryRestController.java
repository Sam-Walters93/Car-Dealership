package cardealership.restControllers;

import cardealership.models.Vehicle;
import cardealership.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryRestController {

    VehicleRepository vehicleRepo;

    @Autowired
    public InventoryRestController(VehicleRepository vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @GetMapping("/new")
    public List<Vehicle> showNewInventories(Model model) {
        return vehicleRepo.findAll()
                .stream()
                .filter(x -> !x.isSold())
                .filter(x -> x.getType().equals("New"))
                .toList();
    }

    @GetMapping("/used")
    public List<Vehicle> showUsedInventories(Model model) {
        return vehicleRepo.findAll()
                .stream()
                .filter(x -> !x.isSold())
                .filter(x -> x.getType().equals("Used"))
                .toList();
    }

    @GetMapping("/details/{id}")
    public Vehicle showDetail(@PathVariable int id) {
        return vehicleRepo.findById(id).orElse(null);
    }

    @GetMapping("/contact")
    public String showContact() {
        return "home/contact";
    }
}
