package project.mbickne1.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.mbickne1.bot.commands.ServerInfo;
import project.mbickne1.bot.components.impl.CommandComponent;
import project.mbickne1.bot.service.DiscordService;

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

		this.botService.registerCommands(
				new CommandComponent[]{
						new CommandComponent<ServerInfo>(new ServerInfo())
				});
	}

	@RequestMapping("/")
	String home() {
		return "Hello World";
	}

}
