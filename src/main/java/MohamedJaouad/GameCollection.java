package MohamedJaouad;

import MohamedJaouad.Games.Game;

import java.util.ArrayList;
import java.util.List;

public class GameCollection {
private List<Game> games = new ArrayList<>();

    public void addGame(Game newGame) {
        boolean exist = games.stream().anyMatch(game -> game.getId() == newGame.getId());
        if (exist) {
            throw new IllegalArgumentException("esiste già un gioco con questo ID: " + newGame.getId());
        }
        games.add(newGame);
    }
    public Game findById(int id) {
        return games.stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("id non trovato: " + id));
    }
    public List<Game> findByPrice(double price){

        List<Game> result = games.stream().filter(game -> game.getPrice()<price).toList();
        if (result.isEmpty()) {
            throw new IllegalArgumentException("nessun gioco trovato con prezzo inferiore a " + price);
        }
        return result;
    }
}

