package com.ldj.demo.mail;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;
/**
 * @author ldj
 * @date 2019/4/29 17:45
 */

/**
 * 提供邮件发送服务
 */
@Component
public class MailSender {
    private static String FromEmail = "1223042416@qq.com";
    private static String EmailPassword = "fvikvejnsqgghbdb";
    private static String EmailSMTPhost = "smtp.qq.com";

    public static boolean  sendMail(String toEmail , String identifyCode){
        boolean falg =false;
        Properties props = new Properties();

//        设置邮件Debug功能
        props.setProperty("smtp.debug", "true");

//        设置是否开启邮件认证功能
        props.setProperty("mail.smtp.auth", "true");

//        设置SMTP端口
        props.put("mail.smtp.port", 25);

//        设置邮件传输的协议
        props.setProperty("mail.transport.protocol", "smtp");

//        设置发送验证邮件的邮箱
        props.setProperty("mail.smtp.host", EmailSMTPhost);

        Session session = Session.getInstance(props);
        session.setDebug(true);

        Message msg = new MimeMessage(session);
        try {
            msg.setSubject("验证码");
            msg.setText(identifyCode);
            msg.setSentDate(new Date());
            msg.setFrom(new InternetAddress(FromEmail,"验证码","UTF-8"));

            Transport transport = session.getTransport();
            transport.connect(EmailSMTPhost,FromEmail,EmailPassword);

            transport.sendMessage(msg, new Address[] {new InternetAddress(toEmail)});

            transport.close();
            falg=true;
        } catch (UnsupportedEncodingException | MessagingException e) {
            e.printStackTrace();
        }
        return falg;
    }
}
