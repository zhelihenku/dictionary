package com.zhelihenku.dictionary.multi.service.impl;

import com.zhelihenku.dictionary.core.common.constant.DatasourceEnum;
import com.zhelihenku.dictionary.core.mutidatasource.annotion.DataSource;
import com.zhelihenku.dictionary.multi.entity.Test;
import com.zhelihenku.dictionary.multi.mapper.TestMapper;
import com.zhelihenku.dictionary.multi.service.TestService;
import com.zhelihenku.dictionary.core.common.constant.DatasourceEnum;
import com.zhelihenku.dictionary.multi.entity.Test;
import com.zhelihenku.dictionary.multi.mapper.TestMapper;
import com.zhelihenku.dictionary.multi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author PhilWang
 * @since 2018-07-10
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    @Transactional
    public void testBiz() {
        Test test = new Test();
        test.setBbb("bizTest");
        testMapper.insert(test);
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_GUNS)
    @Transactional
    public void testGuns() {
        Test test = new Test();
        test.setBbb("gunsTest");
        testMapper.insert(test);
    }

    @Override
    @Transactional
    public void testAll() {
        testBiz();
        testGuns();
        //int i = 1 / 0;
    }

}
