package cn.wolfcode.p2p.base.service.impl;

import cn.wolfcode.p2p.base.domain.Login;
import cn.wolfcode.p2p.base.mapper.LoginMapper;
import cn.wolfcode.p2p.base.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 123 on 2018/2/14.
 */
@Service
public class LoginServiceImpl implements ILoginService{
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public int save(Login login) {
        return loginMapper.insert(login);
    }
}
