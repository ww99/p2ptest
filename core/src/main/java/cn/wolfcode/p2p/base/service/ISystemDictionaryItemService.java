package cn.wolfcode.p2p.base.service;

import cn.wolfcode.p2p.base.domain.SystemDictionary;
import cn.wolfcode.p2p.base.domain.SystemDictionaryItem;
import cn.wolfcode.p2p.base.qo.SystemDictionaryItemQueryObject;
import cn.wolfcode.p2p.base.util.PageResult;

import java.util.List;

/**
 * Created by 123 on 2018/2/20.
 */
public interface ISystemDictionaryItemService {
    int save(SystemDictionaryItem systemDictionaryItem);
    int update(SystemDictionaryItem systemDictionaryItem);
    SystemDictionaryItem get(Long id);
    List<SystemDictionaryItem> list();

    PageResult query(SystemDictionaryItemQueryObject qo);

    List<SystemDictionary> selectParent();

    List<SystemDictionaryItem> queryListByParentSn(String sn);
}
