package canard.esport.recrutement.services;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVReader;

import canard.esport.recrutement.model.Player;

@RestController
public class MainService {
    private List<Player> listPlayers = new LinkedList<>();

    /**
     * Méthode permettant de calculer le poids d'une donnée.
     * @return List<player> - La liste des meilleurs joueurs pondérée et triée.
     */
    @RequestMapping("/calculPonderation")
    public List<Player> calculPonderation(
            @RequestParam
                    int rank,
            @RequestParam
                    int champs,
            @RequestParam
                    int winrate) {

        for (Player player : listPlayers) {
            int score = (player.getRank() * 10 * rank + player.getChamps() * 2 * champs + player.getWinrate() * winrate) / 3;
            player.setScore(score);
        }

        listPlayers.sort(Comparator.comparing(Player::getScore));
        Collections.reverse(listPlayers);

        System.out.println("listPlayers pondérée = " + listPlayers);

        return listPlayers;
    }

    /**
     * Méthode permettant de récupérer la liste des meilleurs joueurs selon leurs statistiques.
     * @return List<Player> - La liste des joueurs triée.
     */
    @RequestMapping("/topPlayers")
    public List<Player> topPlayers() {
        List<List<String>> records = new ArrayList<List<String>>();
        try (CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\maabdela\\Downloads\\EPSI\\Workshop\\recrutement\\src\\main\\resources\\data.csv"))) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            System.out.println("Impossible to access following file : " + e);
        }

        for (List<String> record : records) {
            String joueur = record.get(0);
            List<String> listAttributs = Arrays.asList(joueur.split(";"));
            Player player = new Player(listAttributs.get(0), Integer.parseInt(listAttributs.get(1)), Integer.parseInt(listAttributs.get(3)),
                    Integer.parseInt(listAttributs.get(4)));
            listPlayers.add(player);
        }

        for (Player player : listPlayers) {
            int score = (player.getRank() * 10 + player.getChamps() * 2 + player.getWinrate()) / 3;
            player.setScore(score);
        }

        listPlayers.sort(Comparator.comparing(Player::getScore));
        Collections.reverse(listPlayers);

        System.out.println("listPlayers = " + listPlayers);

        return listPlayers;
    }
}
