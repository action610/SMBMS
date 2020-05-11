package com.smbms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smbms.dao.UserMapper;
import com.smbms.pojo.User;
import com.smbms.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    //显示用户列表
    @Override
    public PageInfo<User> getUserList(Integer pageIndex) throws Exception {
        //设置页码和页面大小
        PageHelper.startPage(pageIndex,8);
        UserExample example=new UserExample();
        List<User> list = userMapper.selectByExample(example);
        //把分页后的list封装到带有页面信息的PageInfo中
        PageInfo<User> userPageInfo=new PageInfo<>(list);
        return userPageInfo;
    }
    //添加用户
    @Override
    public void addUser(User user) throws Exception {
        userMapper.insertSelective(user);
    }
    //删除用户
    @Override
    public void deluser(Integer uid) throws Exception{
        long id=uid.longValue();
        userMapper.deleteByPrimaryKey(id);
    }
    //查看用户详情
    @Override
    public User userView(Integer uid) throws Exception{
        long id=uid.longValue();
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
    //更新用户
    @Override
    public void usermodify(User user)throws Exception {
        userMapper.modify(user);
    }
}
