package com.example.springboottask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTaskApplicationTests {

    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setSubject("通知-今晚开会");
        mailMessage.setText("今晚7：30开会");
        mailMessage.setTo("2102349285@qq.com");
        mailMessage.setFrom("948069223@qq.com");
        mailSender.send(mailMessage);
    }

    @Test
    public void test02() throws MessagingException {
        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);


        helper.setSubject("通知-今晚开会");
        helper.setText("<b style='color:red'>今晚7：30开会</b>",true);
        helper.setTo("2102349285@qq.com");
        helper.setFrom("948069223@qq.com");

        //上传文件
        helper.addAttachment("1.jpg",new File("C:\\Users\\94806\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\94806\\Desktop\\2.jpg"));
        mailSender.send(mimeMessage);
    }

}
