package com.seagrey.service;

import com.seagrey.po.User;

public interface UserService {
    User checkUser(String username,String password);
}
