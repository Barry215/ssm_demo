package com.frank.controller;


import com.frank.Base.BaseTest;
import com.frank.dto.SignUpForm;
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
        SignUpForm signUpForm = new SignUpForm();
        signUpForm.setPhoneCode("111111");
        signUpForm.setUser(user);
        logger.info("注册结果："+userController.getRegisterResult(signUpForm,session));

    }

}