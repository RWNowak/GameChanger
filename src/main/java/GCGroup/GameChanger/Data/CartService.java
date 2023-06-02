package GCGroup.GameChanger.Data;

import GCGroup.GameChanger.Data.Game;
import GCGroup.GameChanger.Data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    private final UserRepository userRepository;

    @Autowired
    public CartService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addToCart(Game game) {
        // Check if the game already exists in the cart
        Optional<Game> existingGame = userRepository.findById(game.getGameId());
        if (existingGame.isPresent()) {
            // Game already exists, return false
            return false;
        }

        // Add the game to the cart
        userRepository.save(game);

        // Game added successfully, return true
        return true;
    }

    public void removeFromCart(int gameId) {
        // Remove the game from the cart by game ID
        userRepository.deleteById(gameId);
    }
}

