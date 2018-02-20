package cn.wolfcode.p2p.business.service;

import cn.wolfcode.p2p.business.domain.SystemMenu;
import cn.wolfcode.p2p.business.qo.SystemMenuQueryObject;

import java.util.List;

/**
 * Created by 123 on 2018/2/20.
 */
public interface ISystemMenuService {
    int save(SystemMenu systemMenu);
    int update(SystemMenu systemMenu);
    int delete(Long id);
    SystemMenu get(Long id);
    List<SystemMenu> list();
    int queryPageCount(SystemMenuQueryObject qo);
    SystemMenu queryPageDataResult(SystemMenuQueryObject qo);

}