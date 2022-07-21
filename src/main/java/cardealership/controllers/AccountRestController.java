package cardealership.controllers;

import cardealership.models.User;
import cardealership.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountRestController {


//                                               I don't think we need it

//    UserRepository userRepo;
//
//    @GetMapping("/login")
//    public String showLogin(Model model) {
//        model.addAttribute("user", new User());
//        return "account/login";
//    }
//
//    @PostMapping("/login")
//    public String login(User user) {
//        User foundUser = userRepo.findById(user.getId()).orElse(null);
//        if (foundUser != null) {
//            return "home/index";
//        }
//        return "account/login";
//    }
//
//    @GetMapping("changePassword")
//    public String showChangePassword(Integer id, Model model) {
//        User user = userRepo.findById(id).orElse(null);
//        return "account/changePassword";
//    }
//
//    @PostMapping("changePassword")
//    public String changePassword(Integer id, Model model) {
//        User user = userRepo.findById(id).orElse(null);
//        return "account/changePassword";
//    }

}
