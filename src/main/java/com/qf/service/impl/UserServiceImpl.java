package com.qf.service.impl;

import com.qf.mapper.UserMapper;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String getUpwdByUname(String uname) {
        return userMapper.getUpwdByUname(uname);
    }

    @Override
    public String getSaltByUname(String uname) {
        return userMapper.getSaltByUname(uname);
    }

    @Override
    public Set<String> getRolenameByUname(String uname) {
        return userMapper.getRolenameByUname(uname);
    }

    @Override
    public int getUidByUname(String uname) {
        return userMapper.getUidByUname(uname);
    }
}
