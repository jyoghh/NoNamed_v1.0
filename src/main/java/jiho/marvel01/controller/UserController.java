package jiho.marvel01.controller;

import jiho.marvel01.domain.Repository.UserRepository;
import jiho.marvel01.dto.AjaxTest;
import jiho.marvel01.dto.UserDto;
import jiho.marvel01.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    @PostMapping("/register_user")
    public String register(UserDto userDto) {
        userService.saveUser(userDto);
        return "redirect:/user_setting";
    }

    @GetMapping("/user_setting")
    public String userList(Model model) {
        List<UserDto> userList = userService.getUserlist();
        model.addAttribute("UserList",userList);
        return "/page/Sys_setting/user_setting";
    }

    @DeleteMapping("/user_setting/{uid}")
    public String deleteUser(@PathVariable("uid") Long uid) {
        userService.deleteUser(uid);
        return "done!";
    }

    @RequestMapping("test.do")
    public @ResponseBody Object testDatatable(HttpServletRequest request,
                                              HttpServletResponse response) {
//        List<UserDto> userList = userService.getUserlist();
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", userService.getUserlist());
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/requestObject", method = RequestMethod.POST)
    @ResponseBody
    public String simpleWithObject(AjaxTest ajaxTest) {
        return ajaxTest.getName() + ajaxTest.getAge();
    }

    @RequestMapping(value = "/deleteUsers.do", method = RequestMethod.POST)
    public String deleteUsers() {
        userRepository.deleteAll();
        return "success";
    }

}

