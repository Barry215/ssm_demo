package com.frank.service.Impl;

import com.frank.service.MailService;
import com.frank.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 邮箱业务
 *
 * @author barry215
 * @create 2016-10-03 16:48
 */
@Service
public class MailServiceImpl implements MailService {

    private String activateCode = "sgh";
    private String FROM = "15958041842@163.com";//发件人的email
    private String PWD = "maijinYAHU2016";//发件人密码


    public boolean sendValidateMail(String EmailAddress) {
        return sendEmail(EmailAddress,getValidateLink(EmailAddress));
    }


    public boolean validateMail(String EmailAddress, String ValidateCode) {
        return MD5Util.validate(EmailAddress+ activateCode,ValidateCode);
    }

    public String getValidateCode(String EmailAddress){
        return MD5Util.encode2hex(EmailAddress+activateCode);
    }

    public String getValidateLink(String EmailAddress){
        StringBuffer sb=new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
        sb.append("<a href=\"http://localhost:8080/mail/validate?EmailAddress=");
        sb.append(EmailAddress);
        sb.append("&ValidateCode=");
        sb.append(getValidateCode(EmailAddress));
        sb.append("\">href=\"http://localhost:8080/mail/validate?EmailAddress=");
        sb.append(EmailAddress);
        sb.append("&ValidateCode=");
        sb.append(getValidateCode(EmailAddress));
        sb.append("</a>");

        return sb.toString();
    }

    public boolean sendEmail(String EmailAddress,String ValidateLink){
        Session session = getSession();
        try {
            System.out.println("--send--"+ValidateLink);
            // Instantiate a message
            Message msg = new MimeMessage(session);

            //Set message attributes
            msg.setFrom(new InternetAddress(FROM));
            InternetAddress[] address = {new InternetAddress(EmailAddress)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("账号激活邮件");
            msg.setSentDate(new Date());
            msg.setContent(ValidateLink , "text/html;charset=utf-8");

            //Send the message
            Transport.send(msg);
            return true;
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
    }

    private Session getSession() {
        String HOST = "smtp.163.com";
        String PROTOCOL = "smtp";
        int PORT = 25;

        Properties props = new Properties();
        props.put("mail.smtp.host", HOST);//设置服务器地址
        props.put("mail.store.protocol" , PROTOCOL);//设置协议
        props.put("mail.smtp.port", PORT);//设置端口
        props.put("mail.smtp.auth" , true);

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, PWD);
            }
        };

        return Session.getDefaultInstance(props , authenticator);
    }
}
