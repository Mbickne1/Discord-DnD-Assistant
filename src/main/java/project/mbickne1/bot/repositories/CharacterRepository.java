package project.mbickne1.bot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.mbickne1.bot.entities.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
