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
                20,
                4,
                90);
        collection.addGame(v1);
        collection.addGame(b1);

        try {
            Game updated = collection.ubdateGame(1,
                    new VideoGame("FIFA 26",
                            LocalDate.of(2026, 9, 1),
                            79.99,
                            Platform.PS5,
                            "50h",
                            Type.SPORTS));

            System.out.println("gioco aggiornato: " + updated.getTitle());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}

