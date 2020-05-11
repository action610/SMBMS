package com.smbms.controller;

import com.smbms.pojo.User;
import com.smbms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    //登录
    @RequestMapping("/login")
    public String login(String usercode, String password, Model model, HttpSession session) throws Exception {
        User user = loginService.login(usercode);
        if(user==null){
            model.addAttribute("usernameerror","用户不存在");
            return "forward:/index.jsp";
        }else{
            if(password.equals(user.getUserpassword())){
                session.setAttribute("loginuser",user);
                return "frame";
            }else {
                model.addAttribute("passworderror","密码错误");
                return "forward:/index.jsp";
            }
        }
    }
    //注销用户
    @RequestMapping("/logout")
    public String logout(HttpSession session)throws Exception{
        session.removeAttribute("loginuser");
        return "frame";
    }
}
