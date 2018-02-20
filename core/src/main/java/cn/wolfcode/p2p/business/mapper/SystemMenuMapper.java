package cn.wolfcode.p2p.business.mapper;

import cn.wolfcode.p2p.business.domain.SystemMenu;
import cn.wolfcode.p2p.business.qo.SystemMenuQueryObject;

import java.util.List;

public interface SystemMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemMenu record);

    SystemMenu selectByPrimaryKey(Long id);

    List<SystemMenu> selectAll();

    int updateByPrimaryKey(SystemMenu record);

    int queryPageCount(SystemMenuQueryObject qo);

    SystemMenu queryPageDataResult(SystemMenuQueryObject qo);
}