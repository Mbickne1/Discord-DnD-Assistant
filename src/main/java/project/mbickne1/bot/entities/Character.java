package project.mbickne1.bot.entities;

import javax.persistence.*;

@Entity
@Table(name = "character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ManyToOne
    private Long character_id;

//    @OneToOne(mappedBy = "campaign_id")
    @Column(name = "campaign_id")
    private Long campaign_id;
//    @OneToOne(mappedBy = "user_id")
    @Column(name = "owner_id")
    private Long owner_id;

    @Column(name = "subclass")
    private String subclass;

    @Column(name = "level")
    private String level;

    @Column(name = "alignment")
    private String alignment;

    @Column(name = "race")
    private String race;

    @Column(name = "name")
    private String name;

    public Character() {

    }

    public Character(
            Long id,
            Long campaign_id,
            Long owner_id,
            String subclass,
            String level,
            String alignment,
            String race,
            String name
    ) {
        this.character_id = id;
        this.campaign_id = campaign_id;
        this.owner_id = owner_id;
        this.subclass = subclass;
        this.level = level;
        this.alignment = alignment;
        this.race = race;
        this.name = name;
    }

    public Long getId() {
        return character_id;
    }

    public void setId(Long id) {
        this.character_id = id;
    }

    public Long getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(Long campaign_id) {
        this.campaign_id = campaign_id;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }
}
