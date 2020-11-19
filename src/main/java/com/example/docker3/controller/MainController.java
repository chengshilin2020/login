package com.example.docker3.controller;


import com.example.docker3.config.WebSecurityConfig;
import com.example.docker3.entity.User;
import com.example.docker3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author csl
 */
@Controller
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
        model.addAttribute("name", account);
        return "index";
    }

    @PostMapping("/user/login")
    @ResponseBody
    public Map<String, Object> loginPost(String username, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        List<User> userList = userService.getUserByName(username);
        if (userList.size() == 0) {
            map.put("success", false);
            map.put("message", "该用户不存在");
            return map;
        }

        // 设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, username);

        map.put("success", true);
        map.put("message", "登录成功");
        return map;
    }

    @PostMapping("/user/relist")
    @ResponseBody
    public Map<String, Object> relist(String username, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        User us = new User();
        us.setUsername(username);
        us.setPassword(password);
        userService.save(us);
        // 设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
        session.setMaxInactiveInterval(1 * 60);
        map.put("success", true);
        map.put("message", "注册成功");
        return map;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }

    @GetMapping("/{pageName}")
    public String toPage(@PathVariable("pageName") String pageName) {
        return pageName;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public List<String> getUserList() {
        List<User> user = userService.getUserList();
        return user.stream().map(user1 -> user1.getUsername()).collect(Collectors.toList());
    }
}
