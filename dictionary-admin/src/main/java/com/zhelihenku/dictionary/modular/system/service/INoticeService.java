package com.zhelihenku.dictionary.modular.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhelihenku.dictionary.modular.system.model.Notice;
import com.zhelihenku.dictionary.modular.system.model.Notice;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 通知表 服务类
 * </p>
 *
 * @author PhilWang
 * @since 2018-02-22
 */
public interface INoticeService extends IService<Notice> {

    /**
     * 获取通知列表
     */
    List<Map<String, Object>> list(String condition);
}
