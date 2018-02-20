package cn.wolfcode.p2p.business.service.impl;

import cn.wolfcode.p2p.business.domain.SystemMenu;
import cn.wolfcode.p2p.business.mapper.SystemMenuMapper;
import cn.wolfcode.p2p.business.qo.SystemMenuQueryObject;
import cn.wolfcode.p2p.business.service.ISystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 123 on 2018/2/20.
 */

@Service@Transactional
public class SystemMenuServiceImpl implements ISystemMenuService{
    @Autowired
    private SystemMenuMapper systemMenuMapper;
    @Override
    public int save(SystemMenu systemMenu) {
        return systemMenuMapper.insert(systemMenu);
    }

    @Override
    public int update(SystemMenu systemMenu) {
        return systemMenuMapper.updateByPrimaryKey(systemMenu);
    }

    @Override
    public int delete(Long id) {
        return systemMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SystemMenu get(Long id) {
        return systemMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemMenu> list() {
        return systemMenuMapper.selectAll();
    }

    @Override
    public int queryPageCount(SystemMenuQueryObject qo) {
        return systemMenuMapper.queryPageCount(qo);
    }

    @Override
    public SystemMenu queryPageDataResult(SystemMenuQueryObject qo) {
        return systemMenuMapper.queryPageDataResult(qo);
    }
}
