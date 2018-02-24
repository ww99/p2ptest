package cn.wolfcode.p2p.base.service.impl;

import cn.wolfcode.p2p.base.domain.MailVerify;
import cn.wolfcode.p2p.base.service.IEmailService;
import cn.wolfcode.p2p.base.service.IMailVerifyService;
import cn.wolfcode.p2p.base.util.BidConst;
import cn.wolfcode.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Created by 123 on 2018/2/22.
 */
@Service@Transactional
public class EmailServiceImpl implements IEmailService {
    @Value("${email.applicationUrl}")
    private String applicationUrl;
    @Autowired
    private IMailVerifyService mailVerifyService;
    @Override
    public void sendEmail(String email) {
        //构建uuid,拼接在地址栏
       String uuid = UUID.randomUUID().toString();
        //构建邮件内容
        StringBuilder msg = new StringBuilder(100);
        msg.append("感谢注册p2p平台,这是您的认证邮件,点击<a href='").append(applicationUrl).append("/bindEmail?key=")
                .append(uuid)
                .append("'>这里</a>完成认证,有效期为").append(BidConst.EMAIL_VALID_TIME).append("天,请尽快认证");
        System.out.println(msg);
        //将发送的邮件地址,发送人id,发送时间,uuid保存入库
        MailVerify mailVerify = new MailVerify();
        mailVerify.setSendTime(new Date());
        mailVerify.setUserId(UserContext.getCurrent().getId());
        mailVerify.setEmail(email);
        mailVerify.setUuid(uuid);
        mailVerifyService.save(mailVerify);
    }
}
