package com.zhelihenku.dictionary.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhelihenku.dictionary.modular.system.dao.RelationMapper;
import com.zhelihenku.dictionary.modular.system.model.Relation;
import com.zhelihenku.dictionary.modular.system.service.IRelationService;
import com.zhelihenku.dictionary.modular.system.dao.RelationMapper;
import com.zhelihenku.dictionary.modular.system.model.Relation;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author PhilWang
 * @since 2018-02-22
 */
@Service
public class RelationServiceImpl extends ServiceImpl<RelationMapper, Relation> implements IRelationService {

}
