package project.mbickne1.bot.controllers;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.mbickne1.bot.entities.Character;
import project.mbickne1.bot.repositories.CampaignRepository;
import project.mbickne1.bot.repositories.CharacterRepository;
import project.mbickne1.bot.repositories.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CampaignRepository campaignRepository;


    @GetMapping("/characters")
    public List<JSONObject> listAll() {
        List<Character> characters = characterRepository.findAll();

        List<JSONObject> res = new ArrayList<JSONObject>();

        for(int i = 0; i < characters.size(); i++) {
            Map<String, String> json = new HashMap<String, String>();

            json.put("race", characters.get(i).getRace());
            json.put("alignment", characters.get(i).getAlignment());
            json.put("level", characters.get(i).getLevel());
            json.put("subclass", characters.get(i).getSubclass());
            json.put("campaign_id", characters.get(i).getCampaign_id().toString());
            json.put("owner_id", characters.get(i).getOwner_id().toString());
            json.put("name", characters.get(i).getName());
            json.put("id", characters.get(i).getId().toString());

            res.add(new JSONObject(json));
        }

        return res;
    }
}
