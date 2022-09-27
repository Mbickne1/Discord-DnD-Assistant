package project.mbickne1.bot.controllers;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.mbickne1.bot.entities.User;
import project.mbickne1.bot.repositories.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping(path = "/api/user")
    public List<JSONObject> listAll() {
        List<User> users = userRepo.findAll();

        List<JSONObject> res = new ArrayList<JSONObject>();

        for(int i = 0; i < users.size(); i++) {
            Map<String, String> json = new HashMap<String, String>();

            json.put("server_id", users.get(i).getServer_id());
            json.put("discord_id", String.valueOf(users.get(i).getDiscord_id()));
            json.put("name", users.get(i).getName());
            json.put("id", users.get(i).getId().toString());

            res.add(new JSONObject(json));
        }


        return res;
    }
}
