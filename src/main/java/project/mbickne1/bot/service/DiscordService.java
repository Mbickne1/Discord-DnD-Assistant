package project.mbickne1.bot.service;

import org.springframework.stereotype.Service;
import project.mbickne1.bot.components.impl.CommandComponent;

import javax.security.auth.login.LoginException;

@Service
public interface DiscordService {

    void start() throws LoginException;

    void registerCommands(CommandComponent[] command);

    void stop();

}
