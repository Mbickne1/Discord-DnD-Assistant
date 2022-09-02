package project.mbickne1.bot.service.impl;

import com.jagrosh.jdautilities.command.Command;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import project.mbickne1.bot.components.impl.CommandComponent;
import project.mbickne1.bot.service.CommandClientService;
import project.mbickne1.bot.service.DiscordService;

import javax.security.auth.login.LoginException;

public class DiscordServiceImpl implements DiscordService {
    private JDA bot;
    private CommandClientService commandService = new CommandClientServiceImpl();

    @Override
    public void start() throws LoginException {
        this.bot = JDABuilder.createDefault("token-goes-here")
                .setActivity(Activity.listening("Juice WRLD"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        this.commandService.createBuilder("$");
    }

    @Override
    public void registerCommands(CommandComponent[] command) {
        for(CommandComponent register : command) {
            this.commandService.registerCommandToBuilder((Command) register.getCommand());
        }

        this.commandService.build();

        this.bot.addEventListener(this.commandService.getClient());
    }

    @Override
    public void stop() {
        this.bot.shutdown();
    }
}
