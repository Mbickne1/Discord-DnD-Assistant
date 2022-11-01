package project.mbickne1.bot.entities;

import javax.persistence.*;

@Entity
@Table(name = "character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long characterId;

//    @OneToOne(mappedBy = "campaign_id")
    @Column(name = "campaignId")
    private Long campaignId;
//    @OneToOne(mappedBy = "user_id")
    //TODO: FIGURE THIS SHIT OUT
    @OneToOne
    @JoinColumn(name = "ownerId", referencedColumnName = "discordId")
//    @Column(name = "ownerId")
    private String ownerId;

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

    public Character() {}

    public Character(
            Long id,
            Long campaignId,
            String ownerId,
            String subclass,
            String level,
            String alignment,
            String race,
            String name
    ) {
        this.characterId = id;
        this.campaignId = campaignId;
        this.ownerId = ownerId;
        this.subclass = subclass;
        this.level = level;
        this.alignment = alignment;
        this.race = race;
        this.name = name;
    }

    public Long getId() {
        return characterId;
    }

    public void setId(Long id) {
        this.characterId = id;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
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
