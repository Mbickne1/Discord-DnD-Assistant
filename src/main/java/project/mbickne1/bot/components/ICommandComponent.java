package project.mbickne1.bot.components;

public interface ICommandComponent<T> {

    T getCommand();

    void setCommand(T command);

}
