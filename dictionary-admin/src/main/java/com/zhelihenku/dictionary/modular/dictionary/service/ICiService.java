package com.zhelihenku.dictionary.modular.dictionary.service;

import com.zhelihenku.dictionary.modular.dictionary.dto.LoadPageListParams;
import com.zhelihenku.dictionary.modular.dictionary.model.Ci;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 词表 服务类
 * </p>
 *
 * @author PhilWang
 * @since 2018-08-20
 */
public interface ICiService extends IService<Ci> {

    Object selectPageList(LoadPageListParams params);
}
