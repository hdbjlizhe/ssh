package com.info.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.info.domain.entity.User;
import com.info.domain.entity.ValidateToken;
import com.info.event.OnRegistrationCompleteEvent;
import com.info.service.IUserService;

import java.util.UUID;

/**
 *  1、生成并保存邮箱验证令牌
 *  2、发送验证邮件
 */
@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
	
	private static final Logger log = LoggerFactory.getLogger(RegistrationListener.class);
	
    @Autowired
    private JavaMailSenderImpl mailSender;

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
        mailMessage.setText("http://localhost:8080"+appurl+"/registationConfirm?token="+token);
        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom(environment.getProperty("mail.from.addr"));
        
        log.info(mailMessage.toString());
        log.info(mailSender.toString());
        mailSender.send(mailMessage);
    }
}
