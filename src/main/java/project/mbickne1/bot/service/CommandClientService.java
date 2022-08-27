package project.mbickne1.bot.service;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;

public interface CommandClientService {

    void createBuilder(String prefix);

    void build();

    void registerCommandToBuilder(Command command);

    CommandClientBuilder getBuilder();

    CommandClient getClient();


}
