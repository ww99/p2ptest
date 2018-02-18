package cn.wolfcode.p2p.base.mapper;

import cn.wolfcode.p2p.base.domain.Account;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    Account selectByPrimaryKey(Long id);

    List<Account> selectAll();

    int updateByPrimaryKey(Account record);
}