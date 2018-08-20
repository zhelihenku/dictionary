package com.zhelihenku.dictionary.rest.modular.auth.validator.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhelihenku.dictionary.rest.modular.example.model.User;
import com.zhelihenku.dictionary.rest.modular.auth.validator.IReqValidator;
import com.zhelihenku.dictionary.rest.modular.auth.validator.dto.Credence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账号密码验证
 *
 * @author PhilWang
 * @date 2017-08-23 12:34
 */
@Service
public class DbValidator implements IReqValidator {



    @Override
    public boolean validate(Credence credence) {
        return true;
    }
}
