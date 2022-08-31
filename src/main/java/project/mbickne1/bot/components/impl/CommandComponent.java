package project.mbickne1.bot.components.impl;

import org.springframework.stereotype.Component;
import project.mbickne1.bot.components.ICommandComponent;

@Component
public class CommandComponent<T> implements ICommandComponent<T> {

    private T command;

    public CommandComponent(T command) {
        this.command = command;
    }

    @Override
    public T getCommand() {
        return this.command;
    }

    @Override
    public void setCommand(T command) {
        this.command = command;
    }
}
