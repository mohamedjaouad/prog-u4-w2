package MohamedJaouad.Games;

import MohamedJaouad.Games.Enum.Platform;
import MohamedJaouad.Games.Enum.Type;

import java.time.LocalDate;

public class VideoGame extends Game {
    private Platform platform;
    private String gameDuration;
    private Type type;

    public VideoGame(String title, LocalDate annoPub, double price,Platform platform,String gameDuration,Type type) {
        super(title, annoPub, price);
        this.platform=platform;
        this.gameDuration=gameDuration;
        this.type=type;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "platform=" + platform +
                ", gameDuration='" + gameDuration + '\'' +
                ", type=" + type +
                '}';
    }
}

