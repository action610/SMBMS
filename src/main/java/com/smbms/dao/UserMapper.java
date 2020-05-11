package com.smbms.dao;

import com.smbms.pojo.User;
import com.smbms.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    //登录页面UserCode查用户详情
    @Select("select * from smbms_user where usercode=#{usercode}")
    User getUserByusercode(String usercode) throws Exception;

    @Update("UPDATE smbms_user SET userName = #{username }, gender = #{gender }, phone = #{phone }, address = #{address } WHERE id = #{id } ")
    void modify(User user) throws Exception;

    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


}