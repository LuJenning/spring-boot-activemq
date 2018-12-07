package com.example.mqdemo.service.impl;

import com.example.mqdemo.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("providerService")
@Slf4j
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private JmsTemplate jmsTemplate;


    @Override
    public void sendMsg(String message) {
        log.info("开始发送消息：" + message);
        // 这里在配置文件中定义了默认地址，所以这里无需再次指定地址
        jmsTemplate.convertAndSend(message);//发送一条消息到默认地址 消息发送调用的是 convertAndSend
    }
    //消息发送的地址 destination指向了${spring.jms.template.default-destination}
    @JmsListener(destination = "${spring.jms.template.default-destination}")
    @Override
    public void receiveMsg(String message) {
        log.info("Receive开始接收消息：" + message);
    }
}