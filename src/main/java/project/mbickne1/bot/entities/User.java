package project.mbickne1.bot.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "discord_id")
    private String discord_id;

    @Column(name = "name")
    private String name;

    @Column(name = "server_id")
    public String server_id;

    public User() {

    }

    public User(Long id, String discord_id, String name, String server_id) {
        this.id = id;
        this.discord_id = discord_id;
        this.server_id = server_id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getDiscord_id() { return this.discord_id; }

    public String getServer_id() { return this.server_id; }

    public String getName() {
        return this.name;
    }

    public void setDiscord_id(String id) {
        this.discord_id = id;
    }

    public void setServer_id(String id) { this.server_id = id; }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "discord_Id: " + this.discord_id;
    }


}
