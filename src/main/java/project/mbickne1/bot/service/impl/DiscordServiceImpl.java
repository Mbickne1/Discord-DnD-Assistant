package project.mbickne1.bot.service.impl;

import com.jagrosh.jdautilities.command.Command;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import project.mbickne1.bot.service.DiscordService;

import javax.security.auth.login.LoginException;

public class DiscordServiceImpl implements DiscordService {
    private JDA bot;

    @Override
    public void start() throws LoginException {
        this.bot = JDABuilder.createDefault("OTg3MDMxODUzNjQwODY3ODQw.GTsQH4.vPpyTEZG2z5XCvreIv9bQhylv1snnxm63u0x4s")
                .setActivity(Activity.listening("Juice WRLD"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
    }

    @Override
    public void registerCommands(Command[] command) {

    }

    @Override
    public void stop() {

    }
}
