package cn.wolfcode.p2p.business.service.impl;

import cn.wolfcode.p2p.business.domain.SystemAccount;
import cn.wolfcode.p2p.business.mapper.SystemAccountMapper;
import cn.wolfcode.p2p.business.service.ISystemAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 123 on 2018/2/19.
 */
@Service@Transactional
public class SystemAccountServiceImpl implements ISystemAccountService{

    @Autowired
    private SystemAccountMapper systemAccountMapper;
    @Override
    public int save(SystemAccount systemAccount) {
        return systemAccountMapper.insert(systemAccount);
    }

    @Override
    public int update(SystemAccount systemAccount) {
        int count = systemAccountMapper.updateByPrimaryKey(systemAccount);
        if (count < 0){
            throw new RuntimeException("乐观锁异常:systemAccountId:"+systemAccount.getId());
        }
        return count;
    }

    @Override
    public SystemAccount selectCurrent() {
        return systemAccountMapper.selectCurrent();
    }

    @Override
    public void initAccount() {
        //查询是否存在系统账户
        SystemAccount systemAccount = this.selectCurrent();
        //不存在.创建
        if (systemAccount == null){
            systemAccount = new SystemAccount();
            this.save(systemAccount);
        }
    }
}
