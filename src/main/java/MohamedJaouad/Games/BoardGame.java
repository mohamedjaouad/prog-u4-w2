package MohamedJaouad.Games;

import java.time.LocalDate;

public class BoardGame extends Game{
    private int numPlayers;
    private int averageDuration;

    public BoardGame(String title, LocalDate annoPub, double price,int numPlayers,int averageDuration) {
        super(title, annoPub, price);
        this.averageDuration=averageDuration;
        this.numPlayers=numPlayers;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "numPlayers=" + numPlayers +
                ", averageDuration=" + averageDuration +
                '}';
    }
}
