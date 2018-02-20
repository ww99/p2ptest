package cn.wolfcode.p2p.base.mapper;

import cn.wolfcode.p2p.base.domain.SystemDictionary;
import cn.wolfcode.p2p.base.qo.SystemDictionaryQueryObject;

import java.util.List;

public interface SystemDictionaryMapper {
    int insert(SystemDictionary record);

    SystemDictionary selectByPrimaryKey(Long id);

    List<SystemDictionary> selectAll();

    int updateByPrimaryKey(SystemDictionary systemDictionary);

    Long queryForCount();

    List<SystemDictionary> queryForList(SystemDictionaryQueryObject qo);
}