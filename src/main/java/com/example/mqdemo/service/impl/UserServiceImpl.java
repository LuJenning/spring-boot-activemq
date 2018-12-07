package com.example.mqdemo.service.impl;

import com.example.mqdemo.dao.UserRepository;
import com.example.mqdemo.entity.User;
import com.example.mqdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {
    private static final String DESTINATION = "my-destination";
    @Autowired
    UserRepository userRepository;
    @Autowired
    JmsTemplate jmsTemplate;

    @Override
    public void sendUser(User user) {
        log.info("发送user对象：" + user.toString());
        jmsTemplate.convertAndSend(DESTINATION, user);
    }

    @JmsListener(destination = DESTINATION)
    @Override
    public void receiveUser(User user) {
        log.info("接收user对象：" + user.toString());
    }

    @Override
    public User findByName(String username) {
        return userRepository.findByName(username);
    }
}
