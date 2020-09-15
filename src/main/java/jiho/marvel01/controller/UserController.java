package jiho.marvel01.controller;

import jiho.marvel01.dto.UserDto;
import jiho.marvel01.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping(value = "/register_user")
    public String register(UserDto userDto) {
        userService.saveUser(userDto);
        return "redirect:/user_setting";
    }

    @RequestMapping(value = "/updateUser.do", method = RequestMethod.POST)
    public @ResponseBody Object update(UserDto userDto,
                                       @RequestParam("uid") Long uid,
                                       @RequestParam("email") String email,
                                       @RequestParam("name") String name,
                                       @RequestParam("corp") String corp,
                                       @RequestParam("dept") String dept,
                                       @RequestParam("status") String status,
                                       @RequestParam("i_group") Integer i_group) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("email", email);
        list.put("name", name);
        list.put("corp", corp);
        list.put("dept", dept);
        list.put("status", status);
        userService.updateUser(uid, list, i_group);
        return list;
    }


    @GetMapping("/user_setting")
    public String userList(Model model) {
        List<UserDto> userList = userService.getUserlist();
        model.addAttribute("UserList",userList);
        return "/page/Sys_setting/user_setting";
    }

    @RequestMapping("test.do")
    public @ResponseBody Object testDatatable(HttpServletRequest request,
                                              HttpServletResponse response) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", userService.getUserlist());
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/deleteuser.do", method = RequestMethod.POST)
    public String deleteuser(@RequestParam("uid") Long uid) {
        userService.deleteUser(uid);
        return "redirect:/user_setting";
    }

    @RequestMapping(value = "/deleteUsers.do", method = RequestMethod.POST)
    public String deleteUsers(@RequestParam(value = "uid[]") List<Long> uid) {
         userService.deleteUsers(uid);
         return "redirect:/user_setting";
    }

    @RequestMapping(value = "/getUser.do", method = RequestMethod.POST)
    public @ResponseBody Object getUser(@RequestParam("uid") Long uid) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", userService.getUser(uid));
        Object result = mp;
        return mp;
    }

}

