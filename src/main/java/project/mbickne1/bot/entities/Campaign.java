package project.mbickne1.bot.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campaignId;

    @Column(name = "name")
    private String name;

    @Column(name = "dungeonMaster")
    private String dungeonMaster;

//    @Column(name = "characters")
    @OneToMany(mappedBy = "characterId")
    private List<Character> characters;

    public Campaign() {

    }

    public Campaign(String name, String dungeonMaster, List<Character> characters) {
        this.name = name;
        this.dungeonMaster = dungeonMaster;
        this.characters = characters;
    }

    public Long getCampaignId() {
        return this.campaignId;
    }

    public void setCampaignId(Long id) {
        this.campaignId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDungeonMaster() {
        return dungeonMaster;
    }

    public void setDungeonMaster(String dungeonMaster) {
        this.dungeonMaster = dungeonMaster;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
