package com.example.mqdemo.util;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {
    //发件人的名字
    public static String userName = "lujianning666";
    //邮箱授权码
    public static String passWord = "666nick";
    //发件人邮箱
    public static String internetAddress = "lujianning666@126.com";
    //邮箱主题
    public static String subject ="用户注册测试";

    public static void sendMail(String email, String emailMsg) throws AddressException, MessagingException {

        // 1.创建一个程序与邮件服务器会话对象 Session

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.host", "smtp.126.com");
        props.setProperty("mail.smtp.auth", "true");// 指定验证为true

        // 创建验证器
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人的名字 授权码
                return new PasswordAuthentication(userName, passWord);
            }
        };

        Session session = Session.getInstance(props, auth);
        //设置调试信息在控制台打印出来
        session.setDebug(true);
        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(internetAddress)); // 设置发送者

        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者

        message.setSubject(subject);//邮件的主题

        // message.setText("这是一封激活邮件，请<a href='#'>点击</a>");

        message.setContent(emailMsg, "text/html;charset=utf-8");

        // 3.创建 Transport用于将邮件发送

        Transport.send(message);
    }
}