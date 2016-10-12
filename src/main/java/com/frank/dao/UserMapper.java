package com.frank.dao;

import com.frank.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateActivate(String EmailAddress);

    String HasEmail(String email);

    String HasPhone(String phone);

    String HasUserName(String username);

    User getUserByEmail(String email);
}