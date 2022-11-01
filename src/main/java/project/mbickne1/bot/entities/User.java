package project.mbickne1.bot.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Consider renaming serverId to GuildID

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToOne
    private Long user_id;

    @Column(name = "discordId")
    private String discordId;

    @Column(name = "name")
    private String name;

    @Column(name = "serverId")
    public String serverId;

    public User() {

    }

    public User(String discord_id, String name, String server_id) {
        this.discordId = discord_id;
        this.serverId = server_id;
        this.name = name;
    }

    public Long getId() {
        return this.user_id;
    }

    public String getDiscordId() { return this.discordId; }

    public String getServerId() { return this.serverId; }

    public String getName() {
        return this.name;
    }

    public void setDiscordId(String id) {
        this.discordId = id;
    }

    public void setServer_id(String id) { this.serverId = id; }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFieldNames() {
        List<String> res = new ArrayList<>(Arrays.asList(
                "userId",
                "discordID",
                "serverId",
                "name"
        ));

        return res;
    }

    @Override
    public String toString() {

        return "{" +
                "user_id: " + this.user_id + ", discordId: " + this.discordId +
                ", name: " + this.name + ", serverId: " + this.serverId
                + "}";
    }


}
