package com.frank.service;

/**
 * Created by barry215 on 2016/10/3.
 */
public interface MailService {

    boolean sendValidateMail(String EmailAddress);

    boolean validateMail(String EmailAddress, String ValidateCode);
}
