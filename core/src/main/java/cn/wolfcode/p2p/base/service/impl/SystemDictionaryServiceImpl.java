package cn.wolfcode.p2p.base.service.impl;

import cn.wolfcode.p2p.base.domain.SystemDictionary;
import cn.wolfcode.p2p.base.mapper.SystemDictionaryMapper;
import cn.wolfcode.p2p.base.qo.SystemDictionaryQueryObject;
import cn.wolfcode.p2p.base.service.ISystemDictionaryService;
import cn.wolfcode.p2p.base.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Created by 123 on 2018/2/20.
 */
@Service@Transactional
public class SystemDictionaryServiceImpl implements ISystemDictionaryService{

    @Autowired
    private SystemDictionaryMapper systemDictionaryMapper;
    @Override
    public int save(SystemDictionary systemDictionary) {
        return systemDictionaryMapper.insert(systemDictionary);
    }

    @Override
    public int update(SystemDictionary systemDictionary) {
        return systemDictionaryMapper.updateByPrimaryKey(systemDictionary);
    }

    @Override
    public SystemDictionary get(Long id) {
        return systemDictionaryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemDictionary> list() {
        return systemDictionaryMapper.selectAll();
    }

    @Override
    public PageResult query(SystemDictionaryQueryObject qo) {
        Long total = systemDictionaryMapper.queryForCount();
        if (total == 0){
            return new PageResult(total, Collections.EMPTY_LIST);
        }
        return new PageResult(total,systemDictionaryMapper.queryForList(qo));
    }
}
