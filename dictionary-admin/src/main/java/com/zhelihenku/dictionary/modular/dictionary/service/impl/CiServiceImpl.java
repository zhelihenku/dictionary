package com.zhelihenku.dictionary.modular.dictionary.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhelihenku.dictionary.modular.dictionary.dto.LoadPageListParams;
import com.zhelihenku.dictionary.modular.dictionary.model.Ci;
import com.zhelihenku.dictionary.modular.dictionary.dao.CiMapper;
import com.zhelihenku.dictionary.modular.dictionary.service.ICiService;
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
    public Object selectPageList(LoadPageListParams params) {

        Page<Ci> page = new Page<Ci>(params.getIndex(), params.getPageSize());

        EntityWrapper<Ci> eWrapper = new EntityWrapper<Ci>();

        List<Ci> ciList = (List<Ci>) selectPage(page, eWrapper);

        return ciList;
    }
}
