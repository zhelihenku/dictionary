package com.zhelihenku.dictionary.rest.modular.dictionary.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.zhelihenku.dictionary.rest.common.util.Result;
import com.zhelihenku.dictionary.rest.modular.dictionary.dto.PageListParams;
import com.zhelihenku.dictionary.rest.modular.dictionary.model.Ci;
import com.zhelihenku.dictionary.rest.modular.dictionary.dao.CiMapper;
import com.zhelihenku.dictionary.rest.modular.dictionary.service.ICiService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 词表 服务实现类
 * </p>
 *
 * @author PhilWang
 * @since 2018-08-20
 */
@Service
public class CiServiceImpl extends ServiceImpl<CiMapper, Ci> implements ICiService {

    @Resource
    private CiMapper ciMapper;

    @Override
    public Object getCiPageList(PageListParams params) {
        Result result = new Result();

        Page page = new Page<>(params.getIndex(), params.getPageSize());
        List<Ci> ciList = ciMapper.selectCiPageList(page);
        page.setRecords(ciList);

        result.setData(page);

        return result;
    }
}
