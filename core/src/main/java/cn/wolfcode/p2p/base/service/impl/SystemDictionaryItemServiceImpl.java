package cn.wolfcode.p2p.base.service.impl;

import cn.wolfcode.p2p.base.domain.SystemDictionary;
import cn.wolfcode.p2p.base.domain.SystemDictionaryItem;
import cn.wolfcode.p2p.base.mapper.SystemDictionaryItemMapper;
import cn.wolfcode.p2p.base.qo.SystemDictionaryItemQueryObject;
import cn.wolfcode.p2p.base.service.ISystemDictionaryItemService;
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
public class SystemDictionaryItemServiceImpl implements ISystemDictionaryItemService{
    @Autowired
    private SystemDictionaryItemMapper systemDictionaryItemMapper;
    @Override
    public int save(SystemDictionaryItem systemDictionaryItem) {
        return systemDictionaryItemMapper.insert(systemDictionaryItem);
    }

    @Override
    public int update(SystemDictionaryItem systemDictionaryItem) {
        return systemDictionaryItemMapper.updateByPrimaryKey(systemDictionaryItem);
    }

    @Override
    public SystemDictionaryItem get(Long id) {
        return systemDictionaryItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemDictionaryItem> list() {
        return systemDictionaryItemMapper.selectAll();
    }

    @Override
    public PageResult query(SystemDictionaryItemQueryObject qo) {
        Long total = systemDictionaryItemMapper.queryForCount();
        if (total == 0){
            return new PageResult(total, Collections.EMPTY_LIST);
        }
        return new PageResult(total,systemDictionaryItemMapper.queryForList(qo));
    }

    @Override
    public List<SystemDictionary> selectParent() {
        List<SystemDictionary> systemDictionaries = systemDictionaryItemMapper.selectParent();
        return systemDictionaries;
    }

    @Override
    public List<SystemDictionaryItem> queryListByParentSn(String sn) {
        return systemDictionaryItemMapper.queryListByParentSn(sn);
    }
}
