package com.seagrey.web.admin;

import com.seagrey.po.User;
import com.seagrey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    //访问登录页
    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    //登录操作
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username,password);
        if(user != null) {
            user.setPassword(null);//避免将密码传入前端
            session.setAttribute("user",user);//将查询到的User对象放入session.
            return "admin/index";
        } else {
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/admin/";
        }
    }

    //注销
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
