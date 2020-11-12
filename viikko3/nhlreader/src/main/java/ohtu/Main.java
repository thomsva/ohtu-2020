package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );
        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        System.out.println("Players from FIN " + java.util.Calendar.getInstance().getTime());
        System.out.println("");
        
        Arrays.sort(players);

        for (Player player : players) {

            if (player.getNationality().equals("FIN")) {
                // Suomi mainittu!
                
                System.out.printf("%-22s", player.getName());
                System.out.printf("%-5s", player.getTeam());
                System.out.printf("%2s", player.getGoals());
                System.out.print(" + ");
                System.out.printf("%2s", player.getAssists());
                System.out.print(" = ");
                System.out.printf("%2s", player.getTotal());
                System.out.print("\n");
                
            }
        }
    }

}
