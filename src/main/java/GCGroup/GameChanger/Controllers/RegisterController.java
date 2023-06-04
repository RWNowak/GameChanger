package GCGroup.GameChanger.Controllers;

import GCGroup.GameChanger.Data.User;
import GCGroup.GameChanger.Data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    private final UserRepository userRepository;

    @Autowired
    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("password2") String password2,
            @RequestParam("email") String email,
            RedirectAttributes redirectAttributes) {

        if (!password.equals(password2)) {
            redirectAttributes.addFlashAttribute("error", "Powtórzone hasło musi być identyczne.");
            return "redirect:/register";
        }

        if (userRepository.findByUsername(username) != null) {
            redirectAttributes.addFlashAttribute("error", "Użytkownik o podanej nazwie już istnieje.");
            return "redirect:/register";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        userRepository.save(user);

        redirectAttributes.addFlashAttribute("success", "Rejestracja zakończona pomyślnie. Możesz się zalogować.");

        return "redirect:/login";
    }
}
