package com.zhelihenku.dictionary.multi.test;

import com.zhelihenku.dictionary.base.BaseJunit;
import com.zhelihenku.dictionary.multi.service.TestService;
import com.zhelihenku.dictionary.base.BaseJunit;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 业务测试
 *
 * @author PhilWang
 * @date 2017-06-23 23:12
 */
public class BizTest extends BaseJunit {

    @Autowired
    TestService testService;

    @Test
    public void test() {
        testService.testGuns();

        testService.testBiz();

        //testService.testAll();
    }
}
