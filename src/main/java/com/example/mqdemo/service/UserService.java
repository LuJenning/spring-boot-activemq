package com.example.mqdemo.service;

import com.example.mqdemo.entity.User;

public interface UserService {

    /**
     * 发送user对象
     *
     * @param user 对象
     */
    void sendUser(User user);

    /**
     * 接收user对象
     *
     * @param user 对象
     */
    void receiveUser(User user);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByName(String username);

}
