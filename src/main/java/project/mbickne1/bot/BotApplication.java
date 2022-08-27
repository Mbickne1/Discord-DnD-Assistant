package project.mbickne1.bot;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.mbickne1.bot.commands.ServerInfo;
import project.mbickne1.bot.service.DiscordService;
import project.mbickne1.bot.service.impl.DiscordServiceImpl;

import javax.security.auth.login.LoginException;

@SpringBootApplication
@RestController
public class BotApplication implements CommandLineRunner {

	private final DiscordService botService;

	public BotApplication(DiscordService botService) {
		this.botService = botService;
	}

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(BotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.botService.start();

		this.botService.registerCommands(new ServerInfo().getChildren());
	}

	@RequestMapping("/")
	String home() {
		return "Hello World";
	}

}
