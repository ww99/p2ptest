package cn.wolfcode.p2p.base.service;

import cn.wolfcode.p2p.base.domain.SystemDictionary;
import cn.wolfcode.p2p.base.qo.SystemDictionaryQueryObject;
import cn.wolfcode.p2p.base.util.PageResult;

import java.util.List;

/**
 * Created by 123 on 2018/2/20.
 */
public interface ISystemDictionaryService {
    int save(SystemDictionary systemDictionary);
    int update(SystemDictionary systemDictionary);
    SystemDictionary get(Long id);
    List<SystemDictionary> list();
    PageResult query(SystemDictionaryQueryObject qo);
}
