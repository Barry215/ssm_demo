package com.frank.controller;

import com.frank.dto.JsonResult;
import com.frank.dto.RegisterResult;
import com.frank.dto.UserForm;
import com.frank.service.MailService;
import com.frank.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * user
 *
 * @author barry215
 * @create 2016-10-02 18:46
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private MailService mailService;

    //返回的是json报文，则要加上produces = {"application/json;charset=UTF-8"}
    @RequestMapping(value = "/signUp", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> getRegisterResult(@RequestBody UserForm userForm, HttpSession httpSession){
        RegisterResult result = userService.getRegisterResult(userForm.getUser());
        if (result.getT_error() == 0){
            if (!mailService.sendValidateMail(userForm.getUser().getEmail())){
                return new JsonResult<String>(true, result.getResult(), "邮箱发送失败");
            }
            return new JsonResult<String>(true, result.getResult(), null);
        }else {
            return new JsonResult<String>(false, result.getResult());
        }
    }
}
