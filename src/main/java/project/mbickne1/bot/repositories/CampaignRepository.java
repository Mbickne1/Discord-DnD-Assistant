package project.mbickne1.bot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.mbickne1.bot.entities.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
}
