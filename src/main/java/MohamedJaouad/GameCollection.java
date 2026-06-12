package MohamedJaouad;

import MohamedJaouad.Games.BoardGame;
import MohamedJaouad.Games.Game;

import java.util.ArrayList;
import java.util.List;

public class GameCollection {
private List<Game> games = new ArrayList<>();
// addGame method
    public void addGame(Game newGame) {
        boolean exist = games.stream().anyMatch(game -> game.getId() == newGame.getId());
        if (exist) {
            throw new IllegalArgumentException("esiste già un gioco con questo ID: " + newGame.getId());
        }
        games.add(newGame);
    }
//    findById method
    public Game findById(int id) {
        return games.stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("id non trovato: " + id));
    }
//    findByPrice method
    public List<Game> findByPrice(double price){

        List<Game> result = games.stream().filter(game -> game.getPrice()<price).toList();
        if (result.isEmpty()) {
            throw new IllegalArgumentException("nessun gioco trovato con prezzo inferiore a " + price);
        }
        return result;
    }
//    findByPlayers method
    public List<BoardGame>  findByNumPlayers(int players){
        List<BoardGame> result=games.stream()
                .filter(game -> game instanceof BoardGame).map( game ->(BoardGame) game)
                .filter(boardGame -> BoardGame.getNumPlayers() == players)
                .toList();
        if (result.isEmpty()){
            throw new IllegalArgumentException(
                    "nessun gioco da tavolo trovato con questo numnero giocatore " + players);
        }
        return result;
    }
// removeById method
    public void removeById(int id){
        boolean remove=games.removeIf(game -> game.getId()==id);
        if (!remove) {
            throw new IllegalArgumentException("nessun gioco trovato con questo ID: " + id);
        }
    }

}

