package project.mbickne1.bot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.mbickne1.bot.service.DiscordService;
import project.mbickne1.bot.service.impl.DiscordServiceImpl;

@Configuration
public class BotApplicationConfiguation {
    private final DiscordService configService;

    public BotApplicationConfiguation() {
        this.configService = new DiscordServiceImpl();
    }

    @Bean
    public DiscordService getBotService() {
        return this.configService;
    }

}
