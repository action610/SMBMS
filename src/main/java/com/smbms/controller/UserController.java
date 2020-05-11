package com.smbms.controller;

import com.github.pagehelper.PageInfo;
import com.smbms.pojo.User;
import com.smbms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //查询用户列表
    @RequestMapping("/userlist")
    public String getUserList(Integer pageIndex,Model model)throws Exception{
        PageInfo<User> pageInfo = userService.getUserList(pageIndex);
        model.addAttribute("pageInfo", pageInfo);
        return "userlist";
    }
    //增加用户
    @RequestMapping("/adduser")
    public String adduser(String userCode,String userName,String userPassword,String gender,String phone,
                          String address,Model model)throws Exception{
        Integer genderInt = Integer.valueOf(gender);
        //封装一个用户
        User user = new User();
        user.setUsercode(userCode);
        user.setUsername(userName);
        user.setUserpassword(userPassword);
        user.setGender(genderInt);
        user.setPhone(phone);
        user.setAddress(address);
        userService.addUser(user);
        //返回到用户列表分页
        PageInfo<User> pageInfo = userService.getUserList(1);
        model.addAttribute("pageInfo",pageInfo);
        return "userlist";
    }
    //删除用户
    @RequestMapping("/deluser")
    public String delUser(Integer uid,Integer pageIndex,Model model)throws Exception{
        userService.deluser(uid);
        PageInfo<User> pageInfo = userService.getUserList(pageIndex);
        model.addAttribute("pageInfo", pageInfo);
        return "userlist";
    }
    //查看用户详情
    @RequestMapping("/userview")
    public String userView(Integer uid,Integer pageIndex,Model model)throws Exception {
        User user = userService.userView(uid);
        model.addAttribute("pageInfo", pageIndex);
        model.addAttribute("User",user);
        return "userview";
    }
    //更新用户第一步
    @RequestMapping("/usermodify")
    public String userModify(Integer uid,Integer pageIndex,Model model)throws Exception {
        User user = userService.userView(uid);
        model.addAttribute("pageInfo", pageIndex);
        model.addAttribute("User",user);
        return "usermodify";
    }
    //更新用户第二步
    @RequestMapping("/usermodify2")
    public String userModify2(Long id,String username,Integer gender,String phone,String address,Model model)throws Exception{
        //封装一个用户类
        User user=new User();
        user.setId(id);
        user.setUsername(username);
        user.setGender(gender);
        user.setPhone(phone);
        user.setAddress(address);
        //更改用户
        userService.usermodify(user);
        //返回一个分页的用户列表
        PageInfo<User> pageInfo = userService.getUserList(1);
        model.addAttribute("pageInfo", pageInfo);
        return "userlist";
    }
}
