package project.mbickne1.bot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.mbickne1.bot.entities.Character;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    Character findCharacterByOwnerId(String ownerId);

    Character findCharacterByOwnerIdAndName(String ownerId, String name);

    Character findCharacterByOwnerIdAndLevel(String ownerId, String level);

    Character findCharacterByOwnerIdAndRace(String ownerId, String race);

    Character findCharacterByOwnerIdAndAlignment(String ownerId, String race);

    //This looks so hilarious I almost don't want to change it
    List<Character> findCharacterByOwnerIdAndAlignmentAndNameAndRaceAndLevel(
            String ownerId,
            String name,
            String race,
            String alignment,
            String level
    );

    //TODO: Perhaps creating all findBy could be useful for administrator purposes.
    //TODO: Is there a way to make findBy params optional so I dont have to make a thousand messages.
}
