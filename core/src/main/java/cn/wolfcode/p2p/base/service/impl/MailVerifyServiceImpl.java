package cn.wolfcode.p2p.base.service.impl;

import cn.wolfcode.p2p.base.domain.MailVerify;
import cn.wolfcode.p2p.base.mapper.MailVerifyMapper;
import cn.wolfcode.p2p.base.service.IMailVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 123 on 2018/2/22.
 */
@Service@Transactional
public class MailVerifyServiceImpl implements IMailVerifyService {
    @Autowired
    private MailVerifyMapper mailVerifyMapper;
    @Override
    public int save(MailVerify mailVerify) {
        return mailVerifyMapper.insert(mailVerify);
    }

    @Override
    public MailVerify get(String uuid) {
        return mailVerifyMapper.selectByUUID(uuid);
    }

}
