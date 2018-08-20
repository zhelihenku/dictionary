package com.zhelihenku.dictionary.rest.modular.dictionary.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.zhelihenku.dictionary.rest.modular.dictionary.model.Ci;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 词表 Mapper 接口
 * </p>
 *
 * @author PhilWang
 * @since 2018-08-20
 */
public interface CiMapper extends BaseMapper<Ci> {

    List<Ci> selectCiPageList(Page page);
}
