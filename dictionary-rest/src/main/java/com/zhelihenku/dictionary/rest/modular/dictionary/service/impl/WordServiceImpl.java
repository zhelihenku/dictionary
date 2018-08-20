package com.zhelihenku.dictionary.rest.modular.dictionary.service.impl;

import com.zhelihenku.dictionary.rest.modular.dictionary.model.Word;
import com.zhelihenku.dictionary.rest.modular.dictionary.dao.WordMapper;
import com.zhelihenku.dictionary.rest.modular.dictionary.service.IWordService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字表 服务实现类
 * </p>
 *
 * @author PhilWang
 * @since 2018-08-20
 */
@Service
public class WordServiceImpl extends ServiceImpl<WordMapper, Word> implements IWordService {

}
