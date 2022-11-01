package project.mbickne1.bot.controllers;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    //TODO: Create api doc .txt for implementing the proper endpoints.
    //TODO: Refactor Character Class to Fix Field Naming Conventions
    //TODO: Should Probably Do Campaign First

    @RequestMapping("/api/v1/characters/all")
    public List<JSONObject> listAll() {
        List<Character> characters = characterRepository.findAll();

        List<JSONObject> res = new ArrayList<JSONObject>();

        for(int i = 0; i < characters.size(); i++) {
            Map<String, String> json = new HashMap<String, String>();

            json.put("race", characters.get(i).getRace());
            json.put("alignment", characters.get(i).getAlignment());
            json.put("level", characters.get(i).getLevel());
            json.put("subclass", characters.get(i).getSubclass());
            json.put("campaign_id", characters.get(i).getCampaignId().toString());
            json.put("owner_id", characters.get(i).getOwnerId().toString());
            json.put("name", characters.get(i).getName());
            json.put("id", characters.get(i).getCharacterId().toString());

            res.add(new JSONObject(json));
        }

        return res;
    }

    @RequestMapping(path = "/api/v1/characters/")
    public List<JSONObject> listByParameter(
            @RequestParam(required = true, name = "ownerId") String ownerId,
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "level") String level,
            @RequestParam(required = false, name = "race") String race,
            @RequestParam(required = false, name = "alignment") String alignment
    ) {
        List<Character> characters;
        List<JSONObject> res = new ArrayList<>();

        if(ownerId == null) {
            Map<String, Boolean> json = new HashMap<String, Boolean>();
            json.put("error", true);

            res.add(new JSONObject(json));

            return res;
        } else {
            characters = characterRepository.findCharacterByOwnerIdAndAlignmentAndNameAndRaceAndLevel(
                    ownerId,
                    name,
                    level,
                    race,
                    alignment
            );
        }

        return null;
    }
}
