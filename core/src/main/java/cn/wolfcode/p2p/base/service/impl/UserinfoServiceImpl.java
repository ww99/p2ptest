package cn.wolfcode.p2p.base.service.impl;

import cn.wolfcode.p2p.base.domain.Userinfo;
import cn.wolfcode.p2p.base.mapper.UserinfoMapper;
import cn.wolfcode.p2p.base.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 123 on 2018/2/18.
 */
@Service@Transactional
public class UserinfoServiceImpl implements IUserinfoService{
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Override
    public int save(Userinfo userinfo) {
        return userinfoMapper.insert(userinfo);
    }

    @Override
    public int update(Userinfo userinfo) {
        return userinfoMapper.updateByPrimaryKey(userinfo);
    }

    @Override
    public Userinfo get(Long id) {
        return userinfoMapper.selectByPrimaryKey(id);
    }
}
