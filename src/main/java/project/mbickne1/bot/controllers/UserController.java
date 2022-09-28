package project.mbickne1.bot.controllers;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    // GET Request for retrieving all User Entities
    @GetMapping(path = "/api/user/all")
    public List<JSONObject> listAll() {
        List<User> users = userRepo.findAll();

        //Refactor This Into A toJSON function -- here or User entity??
        List<JSONObject> res = new ArrayList<JSONObject>();

        for(int i = 0; i < users.size(); i++) {
            Map<String, String> json = new HashMap<String, String>();

            json.put("server_id", users.get(i).getServerId());
            json.put("discord_id", String.valueOf(users.get(i).getDiscordId()));
            json.put("name", users.get(i).getName());
            json.put("id", users.get(i).getId().toString());

            res.add(new JSONObject(json));
        }


        return res;
    }

    //This GET Request is used to get users by either serverId or discordId
    @RequestMapping(path = "api/user/")
    @ResponseBody
    public List<JSONObject> getUserWithParameters(
            @RequestParam(value = "serverId", required = false) String serverId,
            @RequestParam(value = "discordId", required = false) String discordId
    ) {
        List<User> users;
        List<JSONObject> res = new ArrayList<JSONObject>();
        //Check of the parameters were given or not
        if(discordId == null && serverId != null) {
            users = userRepo.findByServerId(serverId);
        } else if(serverId == null && discordId != null) {
            users = new ArrayList<>();
            users.add(userRepo.findByDiscordId(discordId));
        } else {
            Map<String, Boolean> json = new HashMap<String, Boolean>();
            json.put("error", true);

            res.add(new JSONObject(json));

            return res;
        }

        for(int i = 0; i < users.size(); i++) {
            Map<String, String> json = new HashMap<String, String>();

            json.put("server_id", users.get(i).getServerId());
            json.put("discord_id", String.valueOf(users.get(i).getDiscordId()));
            json.put("name", users.get(i).getName());
            json.put("id", users.get(i).getId().toString());

            res.add(new JSONObject(json));
        }

        return res;
    }

    //PUT -- This can be used to create and update an Enitity
    @RequestMapping(path = "api/user/add/")
    @ResponseBody
    public ResponseEntity<User> createUserEntity(
            @RequestParam(value = "discordId", required = false) String discordId,
            @RequestParam(value = "serverId", required = false) String serverId,
            @RequestParam(value = "name", required = false) String name
    ) {
        User user = userRepo.findByDiscordId(discordId);

        if(user == null) {
            user = new User(discordId, name, serverId);
        } else {
            if(name != null) {
                user.setName(name);
            }
            if(serverId != null) {
                user.setServer_id(serverId);
            }
        }

        final User updatedUser = userRepo.save(user);

        System.out.println(user.toString());

        return ResponseEntity.ok(updatedUser);
    }

    //Will want to create a method for updating a discord id
}
