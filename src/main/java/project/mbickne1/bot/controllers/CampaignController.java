package project.mbickne1.bot.controllers;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.mbickne1.bot.entities.Campaign;
import project.mbickne1.bot.repositories.CampaignRepository;

import java.util.*;

@RestController
public class CampaignController {

    @Autowired
    private CampaignRepository campaignRepository;

    @GetMapping("/campaigns")
    public List<JSONObject> listAll() {
        List<Campaign> campaigns = campaignRepository.findAll();

        List<JSONObject> res = new ArrayList<JSONObject>();
        for(int i = 0; i < campaigns.size(); i++) {
            Map<String, String> json = new HashMap<>();

            json.put("characters", campaigns.get(i).getCharacters().toString());
            json.put("dungeon_master", campaigns.get(i).getDungeon_master().toString());
            json.put("name", campaigns.get(i).getName());
            json.put("id", campaigns.get(i).getId().toString());

            res.add(new JSONObject(json));
        }

        return res;
    }
}
