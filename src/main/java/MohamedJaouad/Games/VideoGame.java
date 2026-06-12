package MohamedJaouad.Games;

import java.time.LocalDate;

public class VideoGame extends Game {
    private String platform;
    private String gameDuration;
    private Type type;

    public VideoGame(String title, LocalDate annoPub, double price,String platform,String gameDuration,Type type) {
        super(title, annoPub, price);
        this.platform=platform;
        this.gameDuration=gameDuration;
        this.type=type;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "platform='" + platform + '\'' +
                ", gameDuration='" + gameDuration + '\'' +
                ", type=" + type +
                '}';
    }
}

