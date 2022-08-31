package project.mbickne1.bot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.Arrays;


public class ServerInfo extends Command {

    public ServerInfo() {
        this.name = "server-info";
        this.aliases = new String[]{"server"};
        this.help = "Gives basic user information about the server";
    }

    @Override
    protected void execute(CommandEvent event) {

        //The Embed with all of the server info
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.RED);
        eb.setAuthor(event.getGuild().getName());
        eb.addField("Server Owner:", event.getGuild().getOwner().getEffectiveName(), false);
        eb.addField("Member Count:", Integer.toString(event.getGuild().getMembers().toArray().length), false);

        //Sends the embed as a message
        event.getChannel().sendMessageEmbeds(eb.build()).queue();
        event.getChannel().sendMessage(event.getAuthor().getAsMention()).queue(); //Mentions the user to get their attention
    }

}
