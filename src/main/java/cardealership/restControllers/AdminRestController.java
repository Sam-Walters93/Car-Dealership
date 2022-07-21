package cardealership.restControllers;

import cardealership.models.*;
import cardealership.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
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
        List<Vehicle> vehicles = vehicleRepo.findAll();

        if (!vehicles.isEmpty()) {
            return vehicles;
        } else {
            return null;
        }
    }

    @PostMapping("/addVehicle")
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }


    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();

        if (!users.isEmpty()) {
            return users;
        } else {
            return null;
        }
    }

    @PostMapping("/addUser")
    public User addUser(User user) {
        return userRepo.save(user);
    }


    @GetMapping("/makes")
    public List<Make> getAllMakes() {
        List<Make> makes = makeRepo.findAll();

        if (!makes.isEmpty()) {
            return makes;
        } else {
            return null;
        }
    }

    @PostMapping("/addMake")
    public Make addMake(HttpServletRequest request) {
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        int id = Integer.parseInt(request.getParameter("id"));

        User user = userRepo.findById(id).orElse(null);
        Make make = new Make();

        make.setName(name);
        make.setDateAdded(Date.valueOf(date));
        make.setUser(user);

        return makeRepo.save(make);
    }

    @GetMapping("/models")
    public List<Model> getAllModels() {
        List<Model> models = modelRepo.findAll();

        if (!models.isEmpty()) {
            return models;
        } else {
            return null;
        }
    }

    @PostMapping("/addModel")
    public Model addModel(HttpServletRequest request) {
        String name = request.getParameter("name");
        Date date = Date.valueOf(request.getParameter("date"));
        int makeId = Integer.parseInt(request.getParameter("makeId"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        System.out.printf("name %s%n date %s%n makeID %d%n userID %d%n", name, date, makeId, userId);

        Make make = makeRepo.findById(makeId).orElse(null);
        User user = userRepo.findById(userId).orElse(null);
        Model model = new Model();

        if (make != null && user != null) {
            model.setName(name);
            model.setDateAdded(date);
            model.setUser(user);
            model.setMake(make);
        }
        return modelRepo.save(model);
    }

    @GetMapping("/specials")
    public List<Special> getAllSpecials() {
        List<Special> specials = specialRepo.findAll();

        if (!specials.isEmpty()) {
            return specials;
        } else {
            return null;
        }
    }

    @PostMapping("/addSpecial")
    public Special addSpecial(Special special) {
        System.out.printf("Title: %s%n Description: %s%n", special.getTitle(), special.getDescription());
        return specialRepo.save(special);
    }

    @GetMapping("/removeSpecial/{id}")
    public void removeSpecial(@PathVariable int id) {
        specialRepo.findById(id).ifPresent(special -> specialRepo.delete(special));
    }
}
