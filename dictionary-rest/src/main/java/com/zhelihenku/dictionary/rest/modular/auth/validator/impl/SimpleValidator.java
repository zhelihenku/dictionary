package com.zhelihenku.dictionary.rest.modular.auth.validator.impl;

import com.zhelihenku.dictionary.rest.modular.auth.validator.IReqValidator;
import com.zhelihenku.dictionary.rest.modular.auth.validator.dto.Credence;
import com.zhelihenku.dictionary.rest.modular.auth.validator.dto.Credence;
import org.springframework.stereotype.Service;

/**
 * 直接验证账号密码是不是admin
 *
 * @author PhilWang
 * @date 2017-08-23 12:34
 */
@Service
public class SimpleValidator implements IReqValidator {

    private static String USER_NAME = "admin";

    private static String PASSWORD = "admin";

    @Override
    public boolean validate(Credence credence) {

        String userName = credence.getCredenceName();
        String password = credence.getCredenceCode();

        if (USER_NAME.equals(userName) && PASSWORD.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
