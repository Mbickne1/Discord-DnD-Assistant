package project.mbickne1.bot.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campaign_id;

    @Column(name = "name")
    private String name;

//    @OneToOne(mappedBy = "user_id")
    @Column(name = "dungeon_master")
    private Long dungeon_master;

//    @Column(name = "characters")
    @OneToMany(mappedBy = "characterId")
    private List<Character> characters;

    public Campaign() {

    }

    public Campaign(Long id, String name, Long dungeon_master, List<Character> characters) {
        this.campaign_id = id;
        this.name = name;
        this.dungeon_master = dungeon_master;
        this.characters = characters;
    }

    public Long getId() {
        return campaign_id;
    }

    public void setId(Long id) {
        this.campaign_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDungeon_master() {
        return dungeon_master;
    }

    public void setDungeon_master(Long dungeon_master) {
        this.dungeon_master = dungeon_master;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
