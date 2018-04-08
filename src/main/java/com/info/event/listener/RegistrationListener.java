package com.info.event.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
//import org.springframework.mail.javamail.*;
//import org.springframework.mail.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.info.domain.entity.User;
import com.info.domain.entity.ValidateToken;
import com.info.event.OnRegistrationCompleteEvent;
import com.info.service.IUserService;

import java.io.InputStream;
import java.util.UUID;

import javax.mail.internet.MimeMessage;

/**
 *  1、生成并保存邮箱验证令牌
 *  2、发送验证邮件
 */
@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

    @Autowired
    private MyJavaMailSender mailSender;

    @Autowired
    private IUserService userService;

    @Autowired
    private Environment environment;

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        User user = event.getUser();
        String appurl = event.getAppUrl();
        String token = UUID.randomUUID().toString();
        ValidateToken validateToken = new ValidateToken(user,token);
        userService.saveValidateToken(validateToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("注册确认邮件");
        mailMessage.setText("http://localhost:80"+appurl+"/registationConfirm?token="+token);
        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom(environment.getProperty("mail.from.addr"));

        mailSender.send(mailMessage);
    }
}
