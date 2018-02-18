package cn.wolfcode.p2p.base.service;

import cn.wolfcode.p2p.base.domain.Logininfo;

/**
 * Created by 123 on 2018/2/18.
 */
public interface ILogininfoService {
    int save(Logininfo logininfo);

    Logininfo login(String username,String password,int userType);

    Logininfo register(String username, String password);
}
