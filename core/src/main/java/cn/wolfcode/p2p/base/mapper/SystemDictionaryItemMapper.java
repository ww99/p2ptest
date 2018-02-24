package cn.wolfcode.p2p.base.mapper;

import cn.wolfcode.p2p.base.domain.SystemDictionary;
import cn.wolfcode.p2p.base.domain.SystemDictionaryItem;
import cn.wolfcode.p2p.base.qo.SystemDictionaryItemQueryObject;

import java.util.List;

public interface SystemDictionaryItemMapper {
    int insert(SystemDictionaryItem record);

    SystemDictionaryItem selectByPrimaryKey(Long id);

    List<SystemDictionaryItem> selectAll();

    int updateByPrimaryKey(SystemDictionaryItem record);

    Long queryForCount();

    List<SystemDictionaryItem> queryForList(SystemDictionaryItemQueryObject qo);

    List<SystemDictionary> selectParent();

    List<SystemDictionaryItem> queryListByParentSn(String sn);
}