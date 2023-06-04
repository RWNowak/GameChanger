package GCGroup.GameChanger.Data;

import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final GameRepository gameRepository;

    public CartService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public boolean existsByGameId(int game_id) {
        return gameRepository.existsById(game_id);
    }

    public boolean addToCart(Game game) {
        if (existsByGameId(game.getGameId())) {
            return false;  // Game already in the cart
        }
        gameRepository.save(game);
        return true;  // Game added successfully
    }

    public void removeFromCart(int game_id) {
        gameRepository.deleteById(game_id);
    }
}
