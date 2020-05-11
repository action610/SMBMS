package com.smbms.service;

import com.github.pagehelper.PageInfo;
import com.smbms.pojo.User;

public interface UserService {
    //查询用户列表
    public PageInfo<User> getUserList(Integer pageIndex) throws Exception;
    //添加用户
    public void addUser(User user) throws Exception;
    //删除用户
    void deluser(Integer uid)throws Exception;
    //查看用户详情
    User userView(Integer uid)throws Exception;
    //更新用户
    void usermodify(User user)throws Exception;
}
