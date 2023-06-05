package GCGroup.GameChanger.Controllers;

import java.security.Principal;
import org.springframework.ui.Model;
import GCGroup.GameChanger.Data.User;
import GCGroup.GameChanger.Data.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

  private final UserRepository userRepository;

  public ProfileController(UserRepository userRepository) {
    this.userRepository = userRepository;
}

  @GetMapping("/profile")
  public String showProfilePage(Model model, Principal principal) {
      // Get the username of the currently logged-in user
      String username = principal.getName();
  
      // Retrieve the user object from the database based on the username
      User user = userRepository.findByUsername(username);
  
      // Add the user object to the model
      model.addAttribute("user", user);
  
      // Return the view name of the profile page
      return "profile";
  }
  
}
