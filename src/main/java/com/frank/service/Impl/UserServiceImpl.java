package com.frank.service.Impl;

import com.frank.dao.UserMapper;
import com.frank.dto.RegisterResult;
import com.frank.entity.User;
import com.frank.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User实现类
 *
 * @author barry215
 * @create 2016-10-02 20:29
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public RegisterResult getRegisterResult(User user) {
        int result = userMapper.insertSelective(user);
        if (result == 0){
            return new RegisterResult(1,"注册失败");
        }else {
            return new RegisterResult(0,"注册成功");
        }
    }

    public boolean hasUser(String EmailAddress) {
        return userMapper.HasEmail(EmailAddress)>0;
    }

    public boolean updateActivate(String EmailAddress) {
        if (userMapper.updateActivate(EmailAddress) == 1){
            return true;
        }else {
            return false;
        }

    }
}
