package com.frank.controller;

import com.frank.dto.JsonResult;
import com.frank.service.MailService;
import com.frank.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 邮箱验证
 *
 * @author barry215
 * @create 2016-10-03 16:37
 */
@Controller
@RequestMapping("/mail")
public class MailValidateController {
    @Resource
    private MailService mailService;

    @Resource
    private UserService userService;

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<?> getRegisterResult(@RequestParam("EmailAddress") String EmailAddress
            ,@RequestParam("ValidateCode") String ValidateCode){
        if (mailService.validateMail(EmailAddress,ValidateCode) && userService.hasUser(EmailAddress)){
            if (userService.updateActivate(EmailAddress)){
                return new JsonResult<>(true, "激活成功", null);
            }else {
                return new JsonResult<String>(false, "激活失败");
            }
        }else {
            return new JsonResult<String>(false, "验证码错误或用户不存在或已激活");
        }
    }
}
