package com.frank.service;

import com.frank.dto.RegisterResult;
import com.frank.entity.User;

/**
 * Created by barry215 on 2016/10/2.
 */
public interface UserService {

    RegisterResult getRegisterResult(User user);

    boolean hasUser(String email);

    boolean updateActivate(String email);

}