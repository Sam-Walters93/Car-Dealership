package cardealership.controllers;

import cardealership.models.Vehicle;
import cardealership.repositories.VehicleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    VehicleRepository vehicleRepo;

//    @GetMapping("/new")
//    public String showNewInventories(Model model) {
//        List<Vehicle> vehicles = vehicleRepo.findAll()
//                .stream()
//                .filter(x -> !x.isSold())
//                .filter(x -> x.getType().equals("New"))
//                .toList();
//
//        model.addAttribute("vehicles", vehicles);
//        return "inventory/new";
//    }

    @GetMapping("/searchNew")
    public String showSearchNewResult(Model model, HttpServletRequest request) {
        String make = request.getParameter("make");
        String carModel = request.getParameter("model");
        double min = Double.parseDouble(request.getParameter("min"));
        double max = Double.parseDouble(request.getParameter("max"));
        int year = Integer.parseInt(request.getParameter("year"));

        // need work!

        return "inventory/new";
    }

//    @GetMapping("/used")
//    public String showUsedInventories(Model model) {
//        List<Vehicle> vehicles = vehicleRepo.findAll()
//                .stream()
//                .filter(x -> !x.isSold())
//                .filter(x -> x.getType().equals("Used"))
//                .toList();
//
//        model.addAttribute("vehicles", vehicles);
//        return "inventory/used";
//    }

    @GetMapping("/searchUsed")
    public String showSearchUsedResult(Model model, HttpServletRequest request) {
        String make = request.getParameter("make");
        String carModel = request.getParameter("model");
        double min = Double.parseDouble(request.getParameter("min"));
        double max = Double.parseDouble(request.getParameter("max"));
        int year = Integer.parseInt(request.getParameter("year"));

        // need work!

        return "inventory/new";
    }

    @GetMapping("/details")
    public String showDetail(Integer id, Model model) {
        Vehicle vehicle = vehicleRepo.getReferenceById(id);
        model.addAttribute("vehicle", vehicle);
        return "inventory/details";
    }

    @GetMapping("/contact")
    public String showContact() {
        return "home/contact";
    }
}
