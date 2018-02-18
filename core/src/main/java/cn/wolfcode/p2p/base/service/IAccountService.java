package cn.wolfcode.p2p.base.service;

import cn.wolfcode.p2p.base.domain.Account;

/**
 * Created by 123 on 2018/2/18.
 */
public interface IAccountService {
    int save(Account account);
    int update(Account account);
    Account get(Long id);
}
