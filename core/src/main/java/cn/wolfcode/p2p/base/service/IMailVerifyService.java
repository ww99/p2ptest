package cn.wolfcode.p2p.base.service;

import cn.wolfcode.p2p.base.domain.MailVerify;

/**
 * Created by 123 on 2018/2/22.
 */
public interface IMailVerifyService {
    int save(MailVerify mailVerify);
    MailVerify get(String uuid);
}
