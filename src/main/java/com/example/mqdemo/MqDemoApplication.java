/***************************************************************************
 *
 *  spring boot - apache activemq demo
 *  用户注册成功后发送邮件(异步发送) 用户订阅邮件
 *
 *  参考资料   http://www.cnblogs.com/chenpi/p/5559349.html
 *           https://www.cnblogs.com/cyfonly/p/6380860.html
 *           https://blog.csdn.net/sunguodong_/article/details/79083649
 *           https://blog.csdn.net/Lammonpeter/article/details/83589327
 *
 *
 **************************************************************************/
package com.example.mqdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class MqDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqDemoApplication.class, args);
    }
}
