package MohamedJaouad;

import MohamedJaouad.Games.BoardGame;
import MohamedJaouad.Games.Enum.Platform;
import MohamedJaouad.Games.Enum.Type;
import MohamedJaouad.Games.Game;
import MohamedJaouad.Games.VideoGame;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        GameCollection collection = new GameCollection();
        VideoGame g1 = new VideoGame(
                "Elden Ring",
                LocalDate.of(2022, 2, 25),
                59.99,
                Platform.PC,
                "80h",
                Type.RPG
        );
        BoardGame g2 = new BoardGame(
                "Monopoly",
                LocalDate.of(2000, 1, 1),
                20.00,
                4,
                90
        );
        collection.addGame(g1);
        collection.addGame(g2);

        boolean index=true;
        while (index){
            System.out.println("\n1) Aggiungi gioco");
            System.out.println("2) Cerca per ID");
            System.out.println("3) Cerca per prezzo");
            System.out.println("4) Cerca per numero giocatori ");
            System.out.println("5) Rimuovi gioco per ID");
            System.out.println("6) Aggiorna gioco");
            System.out.println("7) Statistiche");
            System.out.println("0) Esci");
            System.out.println("Scelta: ");
            int scelta= sc.nextInt();
            sc.nextLine();

                switch (scelta){
                    case 1 ->{
                        System.out.println("1) videogioco  o  2) gioco da tavolo");
                        int type = sc.nextInt();
                        sc.nextLine();
                        System.out.print("titolo: ");
                        String title = sc.nextLine();
                        System.out.print("prezzo: ");
                        double price = sc.nextDouble();
                        System.out.print("anno: ");
                        int year = sc.nextInt();
                        System.out.print("mese: ");
                        int month = sc.nextInt();
                        System.out.print("giorno: ");
                        int day = sc.nextInt();
                        LocalDate date = LocalDate.of(year, month, day);
                        if (type == 1) {
                            System.out.print("piattaforma (PS5, XBOX, PC): ");
                            Platform platform = Platform.valueOf(sc.next().toUpperCase());

                            System.out.print("durata media (in ore): ");
                            String duration = sc.next();

                            System.out.print("genere (SPORTS, RPG, ACTION...): ");
                            Type genre = Type.valueOf(sc.next().toUpperCase());

                            collection.addGame(new VideoGame(title, date, price, platform, duration, genre));
                        } else {
                            System.out.print("numero giocatori: ");
                            int players = sc.nextInt();

                            System.out.print("durata media (minuti): ");
                            int avg = sc.nextInt();

                            collection.addGame(new BoardGame(title, date, price, players, avg));
                        }
                        if (title.equalsIgnoreCase("Elden Ring")) {
                            System.out.println("hai aggiunto il gioco più bello al mondo");
                        } else {
                            System.out.println("gioco aggiunto");
                        }

                    }
                    case 2 -> {
                        System.out.print("inserisci un ID: ");
                        int id = sc.nextInt();
                        Game game = collection.findById(id);
                        if (game != null) {
                            System.out.println("Gioco trovato:");
                            System.out.println(game);}
                    }
                    case 3 -> {
                        System.out.print("prezzo massimo: ");
                        double price = sc.nextDouble();
                        List<Game> list = collection.findByPrice(price);
                        if (!list.isEmpty()) {
                            System.out.println("\nRISULTATO");
                            list.forEach(System.out::println);
                        }
                    }
                    case 4 -> {
                        System.out.print("Numero giocatori: ");
                        int players = sc.nextInt();
                        List<BoardGame> list = collection.findByNumPlayers(players);

                        if (!list.isEmpty()) {
                            System.out.println("\nRISULTATO");
                            list.forEach(System.out::println);
                        }
                    }
                    case 5 -> {
                        System.out.print("ID da rimuovere: ");
                        int id = sc.nextInt();

                        Game removed = collection.removeById(id);

                        if (removed != null) {
                            System.out.println("Gioco rimosso:\n");
                            System.out.println(removed);
                        }
                    }
                    case 6 -> {
                        System.out.print("ID del gioco da aggiornare: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        Game old = collection.findById(id);
                        if (old == null) {
                            System.out.println("nessun gioco trovato con questo ID.");
                            break;
                        }

                        System.out.print("nuovo titolo: ");
                        String title = sc.nextLine();

                        System.out.print("nuovo prezzo: ");
                        double price = sc.nextDouble();
                        System.out.print("anno: ");
                        int year = sc.nextInt();
                        System.out.print("mese: ");
                        int month = sc.nextInt();
                        System.out.print("giorno: ");
                        int day = sc.nextInt();
                        LocalDate date = LocalDate.of(year, month, day);
                        Game newGame = new Game(title, date, price);
                        Game updated = collection.updateGame(id, newGame);
                        System.out.println("gioco aggiornato:");
                        System.out.println(updated);
                    }
                    case 7 -> {
                        collection.printStats();
                    }
                    case 0 ->{
                        index=false;
                        System.out.println("sei uscito");
                    }
                }


        }
    }
}

