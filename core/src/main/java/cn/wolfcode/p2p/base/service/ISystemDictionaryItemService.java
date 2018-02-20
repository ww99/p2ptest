package cn.wolfcode.p2p.base.service;

import cn.wolfcode.p2p.base.domain.SystemDictionaryItem;

import java.util.List;

/**
 * Created by 123 on 2018/2/20.
 */
public interface ISystemDictionaryItemService {
    int save(SystemDictionaryItem systemDictionaryItem);
    int update(SystemDictionaryItem systemDictionaryItem);
    SystemDictionaryItem get(Long id);
    List<SystemDictionaryItem> list();
}
