package project.mbickne1.bot.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "discord_id")
    private int discord_id;

    @Column(name = "name")
    private String name;

    public User() {

    }

    public User(Long id, int discord_id, String name) {
        this.id = id;
        this.discord_id = discord_id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public int getDiscord_id() {
        return this.discord_id;
    }

    public String getName() {
        return this.name;
    }

    public void setDiscord_id(int id) {
        this.discord_id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "discord_Id: " + this.discord_id;
    }


}
