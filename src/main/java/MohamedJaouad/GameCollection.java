package MohamedJaouad;

import MohamedJaouad.Games.BoardGame;
import MohamedJaouad.Games.Game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class GameCollection {
private List<Game> games = new ArrayList<>();
// addGame method
    public void addGame(Game newGame) {
        boolean exist = games.stream().anyMatch(game -> game.getId() == newGame.getId());
        if (exist) {
            System.out.println(" esiste già un gioco con ID: " + newGame.getId());
            return;
        }
        games.add(newGame);

    }
//    findById method
    public Game findById(int id) {
        Game result= games.stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElse(null);
        if (result == null) {
            System.out.println(" nessun gioco trovato con ID: " + id);
            return null;
        }
        return result;
    }
//    findByPrice method
    public List<Game> findByPrice(double price){

        List<Game> result = games.stream().filter(game -> game.getPrice()<price).toList();
        if (result.isEmpty()) {
            System.out.println("nessun gioco trovato con prezzo inferiore a " + price);
            return List.of();
        }

        return result;
    }
//    findByPlayers method
    public List<BoardGame>  findByNumPlayers(int players){
        List<BoardGame> result=games.stream()
                .filter(game -> game instanceof BoardGame).map( game ->(BoardGame) game)
                .filter(boardGame -> BoardGame.getNumPlayers() == players)
                .toList();
        if (result.isEmpty()) {
            System.out.println("Nessun gioco da tavolo trovato con " + players + " giocatori.");
            return List.of();
        }
        return result;
    }
// removeById method
    public Game removeById(int id){
        Game toRemove = null;

        for (Game g : games) {
            if (g.getId() == id) {
                toRemove = g;
                break;
            }
        }

        if (toRemove == null) {
            System.out.println("nessun gioco trovato con ID: " + id);
            return null;
        }

        games.remove(toRemove);
        return toRemove;
    }

    //    ubdateGame method
public Game updateGame(int id, Game newGame){
    Game oldGame = games.stream()
            .filter(game -> game.getId() == id)
            .findFirst()
            .orElse(null);
    games.remove(oldGame);
    games.add(newGame);
    return newGame;
}
     public void printStats() {

        if (games.isEmpty()) {
            System.out.println("nessun gioco presente nella collezione.");
            return;
        }

        int total = games.size();

         OptionalDouble avgPrice = games.stream()
                 .mapToDouble(Game::getPrice)
                 .average();

         double media = avgPrice.orElse(0);

         Game maxPrice = games.stream()
                 .max(Comparator.comparingDouble(Game::getPrice))
                 .orElse(null);

         Game minPrice = games.stream()
                 .min(Comparator.comparingDouble(Game::getPrice))
                 .orElse(null);

         System.out.println("totale giochi: " + total + "\n");
         System.out.println("prezzo medio: " + media + "\n");
         System.out.println("gioco più costoso: " + maxPrice + "\n");
         System.out.println("gioco meno costoso: " + minPrice + "\n");

     }

}


