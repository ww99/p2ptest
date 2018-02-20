package cn.wolfcode.p2p.business.service;

import cn.wolfcode.p2p.business.domain.SystemAccount;

/**
 * Created by 123 on 2018/2/19.
 */
public interface ISystemAccountService {
    int save(SystemAccount systemAccount);
    int update(SystemAccount systemAccount);
    SystemAccount selectCurrent();

    void initAccount();
}
