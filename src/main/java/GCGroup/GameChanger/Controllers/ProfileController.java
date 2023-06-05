package GCGroup.GameChanger.Controllers;

import org.springframework.ui.Model;
import GCGroup.GameChanger.Data.UserRepository;
import GCGroup.GameChanger.Data.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

    private final UserRepository userRepository;

    public ProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/profile/{username}")
        public String showProfilePage(Model model, @PathVariable("username") String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
        }

    return "profile";
}

}
