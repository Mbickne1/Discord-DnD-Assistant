package project.mbickne1.bot;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.mbickne1.bot.commands.ServerInfo;

import javax.security.auth.login.LoginException;

@SpringBootApplication
@RestController
public class BotApplication {

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(BotApplication.class, args);
	}

	@Bean
	@ConfigurationProperties(value ="discord-api")
	public JDA startBot() throws LoginException {
		JDA bot = JDABuilder.createDefault("OTg3MDMxODUzNjQwODY3ODQw.GTsQH4.vPpyTEZG2z5XCvreIv9bQhylv1snnxm63u0x4s")
				.setActivity(Activity.listening("Juice WRLD"))
				.enableIntents(GatewayIntent.MESSAGE_CONTENT)
				.build();

		CommandClientBuilder builder = new CommandClientBuilder();

		builder.setOwnerId("987031853640867840");
		//command prefix
		builder.setPrefix("$");
		//Add our command(this is now where we register the commands)
		builder.addCommand(new ServerInfo());
		//build the command client
		CommandClient client = builder.build();
		//We no longer need to register each command class here, we just register the command client
		bot.addEventListener(client);

		return bot;
	}

	@RequestMapping("/")
	String home() {
		return "Hello World";
	}

}
