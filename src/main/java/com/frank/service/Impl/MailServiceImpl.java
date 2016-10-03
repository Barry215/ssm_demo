package com.frank.service.Impl;

import com.frank.dao.UserMapper;
import com.frank.service.MailService;
import com.frank.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 邮箱业务
 *
 * @author barry215
 * @create 2016-10-03 16:48
 */
@Service
public class MailServiceImpl implements MailService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void sendMailValidate(String EmailAddress) {

    }

    @Override
    public boolean validateMail(String EmailAddress, String ValidateCode) {

        String activateCode = "sgh";

        if (MD5Util.validate(EmailAddress+ activateCode,ValidateCode)){
            return true;
        }else {
            return false;
        }

    }
}
