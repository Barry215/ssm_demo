package com.frank.controller;


import com.frank.Base.BaseTest;
import com.frank.dto.UserForm;
import com.frank.entity.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


public class UserControllerTest extends BaseTest{

    @Resource
    private UserController userController;
    HttpSession session = getSession();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void signUp(){
        User user= new User();
        user.setUsername("test002");
        user.setPassword("123456");
        user.setPhone("15958041842");
        user.setSex("G");
        user.setEmail("530438645@qq.com");
        UserForm userForm = new UserForm();
        userForm.setPhoneCode("111111");
        userForm.setUser(user);
        logger.info("注册结果："+userController.getRegisterResult(userForm,session));

    }

}