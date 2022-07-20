package cardealership.controllers;

import cardealership.models.*;
import cardealership.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    VehicleRepository vehicleRepo;
    UserRepository userRepo;
    MakeRepository makeRepo;
    ModelRepository modelRepo;
    SpecialRepository specialRepo;

    @Autowired
    public AdminRestController(VehicleRepository vehicleRepo, UserRepository userRepo, MakeRepository makeRepo, ModelRepository modelRepo, SpecialRepository specialRepo) {
        this.vehicleRepo = vehicleRepo;
        this.userRepo = userRepo;
        this.makeRepo = makeRepo;
        this.modelRepo = modelRepo;
        this.specialRepo = specialRepo;
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    @PostMapping("/addVehicle")
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/addUser")
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @GetMapping("/makes")
    public List<Make> getAllMakes() {
        return makeRepo.findAll();
    }

    @PostMapping("/addMake")
    public Make addMake(Make make) {
        return makeRepo.save(make);
    }

    @GetMapping("/models")
    public List<Model> getAllModels() {
        return modelRepo.findAll();
    }

    @PostMapping("/addModel")
    public Model addModel(Model model) {
        return modelRepo.save(model);
    }

    @GetMapping("/specials")
    public List<Special> getAllSpecials() {
        return specialRepo.findAll();
    }

    @PostMapping("/addSpecial")
    public Special addSpecial(Special special) {
        return specialRepo.save(special);
    }

    @GetMapping("/removeSpecial/{id}")
    public void removeSpecial(@PathVariable int id) {
        specialRepo.findById(id).ifPresent(special -> specialRepo.delete(special));
    }
}
