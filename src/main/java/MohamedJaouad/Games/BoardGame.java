package MohamedJaouad.Games;

import java.time.LocalDate;

public class BoardGame extends Game{
    private static int numPlayers;
    private int averageDuration;

    public BoardGame(String title, LocalDate annoPub, double price,int numPlayers,int averageDuration) {
        super(title, annoPub, price);
        if (numPlayers < 2 || numPlayers> 10) System.out.println("I giocatori devono essere tra 2 e 10");;
        this.averageDuration=averageDuration;
        this.numPlayers=numPlayers;
    }
    public static int getNumPlayers() { return numPlayers; }

    @Override
    public String toString() {
        return
                "ID: " + getId() + "\n" +
                "Titolo: " + getTitle() + "\n" +
                "Giocatori: " + numPlayers + "\n" +
                "Durata media: " + averageDuration + " min\n" +
                "Prezzo: " + getPrice() + "€\n";
    }

}
