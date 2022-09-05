package project.mbickne1.bot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;


public class GetUsers extends Command {

    public GetUsers() {
        this.name = "get-users";
        this.help = "Lists Users That Are Registered To This Server";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {

        URL url = null;
        try {
            url = new URL("http://localhost:8080/user");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        HttpURLConnection conn = null;
        int response;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            response = conn.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (response != 200) {
            throw new RuntimeException("HttpResponseCode: " + response);
        } else {

            String inline = "";
            Scanner scanner = null;
            try {
                scanner = new Scanner(url.openStream());
                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                System.out.println(inline);
                //Close the scanner
                scanner.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }



            //Using the JSON simple library parse the string into a json object
            JSONParser parse = new JSONParser();
            JSONObject data_obj = null;
            try {
                data_obj = (JSONObject) parse.parse(inline);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            //Get the required object from the above created object


            //Get the required data using its key
//            System.out.println(data_obj);
            System.out.println(data_obj.get("id"));
        }
    }


}
