package com.example.mqdemo.controller;

import com.example.mqdemo.dao.UserRepository;
import com.example.mqdemo.entity.User;
import com.example.mqdemo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

@Controller
public class AppController {
    @Autowired
    private ProviderService providerService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/register")
    public String register(User user, HttpSession session,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String email,
                           @RequestParam Integer age)throws MessagingException {

        userRepository.save(user);

        System.out.println("**************************数据写入数据库成功!****************************");

        providerService.sendMsg("用户 " + user.getUsername() + " 注册成功!");
        session.setAttribute("user",user);
        jmsTemplate.send("userEmailDestination", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                message.setString("title", "注册邮件");//这里是邮件的内容
                message.setString("email", email);//页面填入的邮件号码 *****@qq.com *****@163.com
                System.out.println("**************************发送邮件成功!*********************************");
                return message;
            }
        });
        return "/success";
    }
}
