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
    private Long userId;

    @Column(name = "discordId")
    private String discordId;

    @Column(name = "name")
    private String name;

    @Column(name = "serverId")
    public String serverId;

    public User() {

    }

    public User(String discordId, String name, String serverId) {
        this.discordId = discordId;
        this.serverId = serverId;
        this.name = name;
    }

    public Long getUserId() {
        return this.userId;
    }

    public String getDiscordId() { return this.discordId; }

    public String getServerId() { return this.serverId; }

    public String getName() {
        return this.name;
    }

    public void setDiscordId(String id) {
        this.discordId = id;
    }

    public void setServerId(String id) { this.serverId = id; }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFieldNames() {
        return new ArrayList<>(Arrays.asList(
                "userId",
                "discordID",
                "serverId",
                "name"
        ));
    }

    @Override
    public String toString() {

        return "{" +
                "id: " + this.userId + ", discordId: " + this.discordId +
                ", name: " + this.name + ", serverId: " + this.serverId
                + "}";
    }


}
