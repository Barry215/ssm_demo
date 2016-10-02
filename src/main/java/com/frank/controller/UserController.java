package com.frank.controller;

import com.frank.dto.JsonResult;
import com.frank.dto.RegisterResult;
import com.frank.dto.SignUpForm;
import com.frank.entity.User;
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

    @RequestMapping(value = "/signUp", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> getRegisterResult(@RequestBody SignUpForm signUpForm, HttpSession httpSession){
        RegisterResult result = userService.getRegisterResult(signUpForm.getUser());
        if (result.getT_error() == 0){
            return new JsonResult<>(true, result.getResult(), null);
        }else {
            return new JsonResult<String>(false, result.getResult());
        }
    }
}
