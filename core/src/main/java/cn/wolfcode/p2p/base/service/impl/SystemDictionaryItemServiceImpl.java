package cn.wolfcode.p2p.base.service.impl;

import cn.wolfcode.p2p.base.domain.SystemDictionaryItem;
import cn.wolfcode.p2p.base.mapper.SystemDictionaryItemMapper;
import cn.wolfcode.p2p.base.service.ISystemDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
