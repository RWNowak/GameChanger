package GCGroup.GameChanger.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Game {
    @Id
    public int game_id;

    public String title;

    public Game() {
    }

    public Game(int game_id, String title) {
        this.game_id = game_id;
        this.title = title;
    }

    public int getGameId() {
        return game_id;
    }

    public void setGameId(int game_id) {
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
