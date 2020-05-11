package com.smbms.service;

import com.smbms.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LoginService {
    User login(String usercode) throws Exception;
}
