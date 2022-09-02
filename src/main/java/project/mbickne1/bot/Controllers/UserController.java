package project.mbickne1.bot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.mbickne1.bot.entities.User;
import project.mbickne1.bot.repositories.UserRepository;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/user")
    public String listAll() {
        List<User> users = userRepo.findAll();
//        model.addAttribute("listStudents", users);
        return users.toString();
    }
}
