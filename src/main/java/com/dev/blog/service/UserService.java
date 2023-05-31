package com.dev.blog.service;

import com.dev.blog.po.User;

public interface UserService {

    User checkUser(String username,String password);

}
