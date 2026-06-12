package MohamedJaouad.Games;

import java.time.LocalDate;

public abstract class Game {
    private int countID=1;
    private String title;
    private LocalDate annoPub;
    private double price;
    public Game( String title,LocalDate annoPub,double price){

        this.title=title;
        this.annoPub=annoPub;
        this.price=price;
    }

}
