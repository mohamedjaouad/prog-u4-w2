package MohamedJaouad.Games;

import java.time.LocalDate;

public abstract class Game {

    private  int id;
    private String title;
    private LocalDate annoPub;
    private double price;

    private static int countID=1;

    public Game( String title,LocalDate annoPub,double price){
        if (price < 0)
            throw new IllegalArgumentException("il prezzo deve essere positivo");
        this.id=countID++;
        this.title=title;
        this.annoPub=annoPub;
        this.price=price;
    }
    public int getId() { return id; }
    public String getTitle() { return title; }
    public LocalDate getAnnoPub() { return annoPub; }
    public double getPrice() { return price; }

    public void setTitle(String title) { this.title = title; }
    public void setAnnoPub(LocalDate annoPub) { this.annoPub = annoPub; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", annoPub=" + annoPub +
                ", price=" + price +
                ", countID=" + countID +
                '}';
    }
}
