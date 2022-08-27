package project.mbickne1.bot.service.impl;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import project.mbickne1.bot.service.CommandClientService;

public class CommandClientServiceImpl implements CommandClientService {
    private CommandClientBuilder builder;
    private CommandClient client;

    @Override
    public void createBuilder(String prefix) {
        this.builder = new CommandClientBuilder();
        //ownerId
        builder.setOwnerId("987031853640867840");
        //command prefix
        builder.setPrefix("$");
    }

    @Override
    public void build() {
        this.client = this.builder.build();
    }

    @Override
    public void registerCommandToBuilder(Command command) {
        this.builder.addCommand(command);
    }

    @Override
    public CommandClientBuilder getBuilder() {
        return this.builder;
    }

    @Override
    public CommandClient getClient() {
        return this.client;
    }
}
