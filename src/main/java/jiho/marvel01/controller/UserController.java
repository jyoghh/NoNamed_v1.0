package jiho.marvel01.controller;

import jiho.marvel01.domain.Entity.UserEntity;
import jiho.marvel01.dto.UserDto;
import jiho.marvel01.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static org.springframework.util.ObjectUtils.isEmpty;


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
                           @RequestParam("contents[]") HashMap<String, String> contents) {
        UserDto userinfo = new UserDto();
        if(uid > 0) {
            userinfo.setUid(uid);
        }
        userinfo.setName(contents.get("name"));
        userinfo.setEmail(contents.get("email"));
        userinfo.setCorp(contents.get("corp"));
        userinfo.setDepartment(contents.get("dept"));
        userinfo.setI_group( Integer.parseInt(contents.get("i_group")));

        userService.saveUser(userDto);
        return userinfo;
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
//        List<UserDto> userList = userService.getUserlist();
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

