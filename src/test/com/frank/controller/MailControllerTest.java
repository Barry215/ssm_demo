package com.frank.controller;

import com.frank.Base.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 邮箱测试
 *
 * @author barry215
 * @create 2016-10-03 22:57
 */

public class MailControllerTest extends BaseTest{
    @Resource
    private MailValidateController mailValidateController;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void ValidateMail(){
        String Email = "530438645@qq.com";
        String validateCode = "2a8cf02a077e60e339b53131da569e03";
        logger.info("激活结果："+ mailValidateController.getValidateMailResult(Email,validateCode));
    }
}
