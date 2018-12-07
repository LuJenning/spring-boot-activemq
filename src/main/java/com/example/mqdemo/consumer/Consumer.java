package com.example.mqdemo.consumer;


import com.example.mqdemo.util.MailUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.mail.MessagingException;

@Component
public class Consumer {
    @JmsListener(destination = "userEmailDestination")
    public void sendMail(Message message) throws JMSException, MessagingException {
        MapMessage mm = (MapMessage) message;
        String title = mm.getString("title");
        String email = mm.getString("email");
        MailUtils.sendMail(email,title);
    }
}
