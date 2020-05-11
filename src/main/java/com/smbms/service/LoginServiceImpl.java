package com.smbms.service;

import com.smbms.dao.UserMapper;
import com.smbms.pojo.User;
import com.smbms.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String usercode) throws Exception{
        User user = userMapper.getUserByusercode(usercode);
        return user;
    }
}
