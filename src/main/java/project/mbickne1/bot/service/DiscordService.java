package project.mbickne1.bot.service;

import com.jagrosh.jdautilities.command.Command;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public interface DiscordService {

    void start() throws LoginException;

    void registerCommands(Command[] command);

    void stop();

}
