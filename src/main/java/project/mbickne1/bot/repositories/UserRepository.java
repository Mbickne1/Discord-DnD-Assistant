package project.mbickne1.bot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.mbickne1.bot.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByDiscordId(String discordId);
    List<User> findByServerId(String serverId);
}
