package cn.wolfcode.p2p.base.service;

import cn.wolfcode.p2p.base.domain.RealAuth;

import java.util.List;

/**
 * Created by 123 on 2018/2/23.
 */
public interface IRealAuthService {
    int save(RealAuth realAuth);
    int update(RealAuth realAuth);
    RealAuth get(Long id);
    List<RealAuth> list();

    /**
     * 市民认证申请
     * @param realAuth
     */
    void realAuthSave(RealAuth realAuth);
}
