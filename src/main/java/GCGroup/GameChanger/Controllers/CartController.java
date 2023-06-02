package GCGroup.GameChanger.Controllers;

import GCGroup.GameChanger.Data.GameRepository;
import GCGroup.GameChanger.Data.Game;
import GCGroup.GameChanger.Data.CartService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final GameRepository gameRepository;

    public CartController(CartService cartService, @Autowired GameRepository gameRepository) {
        this.cartService = cartService;
        this.gameRepository = gameRepository;
    }

    @GetMapping
    public String showCart(Model model) {
        List<Game> games = gameRepository.findAll(); // Fetch game titles from the database
        model.addAttribute("games", games);
        return "cart";
    }

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody Game game) {
        // Try to add the game to the cart
        boolean added = cartService.addToCart(game);

        if (added) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Game added to cart");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Game is already in the cart");
        }
    }

    @DeleteMapping("/remove/{gameId}")
    public ResponseEntity<String> removeFromCart(@PathVariable int game_id) {
        // Remove the game from the cart
        cartService.removeFromCart(game_id);

        return ResponseEntity.ok("Game removed from cart");
    }
}
