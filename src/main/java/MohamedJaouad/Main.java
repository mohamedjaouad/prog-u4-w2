package MohamedJaouad;

import MohamedJaouad.Games.BoardGame;
import MohamedJaouad.Games.Enum.Platform;
import MohamedJaouad.Games.Enum.Type;
import MohamedJaouad.Games.Game;
import MohamedJaouad.Games.VideoGame;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        GameCollection collection = new GameCollection();
        VideoGame v1 = new VideoGame("FIFA 25",
                LocalDate.of(2025, 9, 1),
                69.99,
                Platform.PS5,
                "40h",
                Type.SPORTS);

        BoardGame b1 = new BoardGame("Monopoly",
                LocalDate.of(2000, 1, 1),
                29.99,
                4,
                90);
        collection.addGame(v1);
        collection.addGame(b1);

        Game result = collection.findById(1);
        System.out.println("Risultato ricerca ID 1:");
        System.out.println(result);
    }
}

