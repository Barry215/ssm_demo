package com.frank.dto;

import com.frank.entity.User;

/**
 * 注册填写表单
 * Created by RichardW on 8/23/2016.
 */
public class UserForm {
    /**
     * 手机验证码
     */
    private String PhoneCode;
    /**
     * 邮箱验证码
     */
    private String EmailCode;
    /**
     * 包装的用户报名信息
     */
    private User user;
    private String imgCode;

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode;
    }

    public String getPhoneCode() {
        return PhoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        PhoneCode = phoneCode;
    }

    public String getEmailCode() {
        return EmailCode;
    }

    public void setEmailCode(String emailCode) {
        EmailCode = emailCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
