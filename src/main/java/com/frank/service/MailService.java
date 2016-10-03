package com.frank.service;

/**
 * Created by barry215 on 2016/10/3.
 */
public interface MailService {

    boolean sendMailValidate(String EmailAddress);

    boolean validateMail(String EmailAddress, String ValidateCode);
}
