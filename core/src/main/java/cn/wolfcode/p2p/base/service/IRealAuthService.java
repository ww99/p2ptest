package cn.wolfcode.p2p.base.service;

import cn.wolfcode.p2p.base.domain.RealAuth;
import cn.wolfcode.p2p.base.qo.RealAuthQueryObject;
import cn.wolfcode.p2p.base.util.PageResult;

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
     * 实名认证申请
     * @param realAuth
     */
    void realAuthSave(RealAuth realAuth);

    PageResult query(RealAuthQueryObject qo);

    /**
     * 实名认证审核方法
     * @param id
     * @param state
     * @param remark
     */
    void audit(Long id, int state, String remark);
}
