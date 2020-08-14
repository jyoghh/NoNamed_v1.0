package jiho.marvel01.controller;

import jiho.marvel01.dto.UserDto;
import jiho.marvel01.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/register_user")
    public String register(UserDto userDto) {
        userService.saveUser(userDto);
        return "redirect:/";
    }
}
