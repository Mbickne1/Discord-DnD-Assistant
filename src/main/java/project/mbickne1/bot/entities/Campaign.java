package project.mbickne1.bot.entities;

import javax.persistence.*;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dungeon_master")
    private String dungeon_master;

    @Column(name = "characters")
    private Character[] characters;

    public Campaign() {

    }

    public Campaign(Long id, String name, String dungeon_master, Character[] characters) {
        this.id = id;
        this.name = name;
        this.dungeon_master = dungeon_master;
        this.characters = characters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDungeon_master() {
        return dungeon_master;
    }

    public void setDungeon_master(String dungeon_master) {
        this.dungeon_master = dungeon_master;
    }

    public Character[] getCharacters() {
        return characters;
    }

    public void setCharacters(Character[] characters) {
        this.characters = characters;
    }
}
