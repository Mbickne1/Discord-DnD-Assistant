package project.mbickne1.bot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.mbickne1.bot.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByDiscordId(String discord_id);
}
