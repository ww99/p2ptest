package cn.wolfcode.p2p.base.service.impl;

import cn.wolfcode.p2p.base.domain.VerifyCode;
import cn.wolfcode.p2p.base.service.IVerifyCodeService;
import cn.wolfcode.p2p.base.util.BidConst;
import cn.wolfcode.p2p.base.util.DateUtil;
import cn.wolfcode.p2p.base.util.UserContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Created by 123 on 2018/2/21.
 */
@Service@Transactional
public class VerifyCodeServiceImpl implements IVerifyCodeService {
    @Override
    public void sendVerifyCode(String phoneNumber) {
        VerifyCode verfyCode = UserContext.getVerfyCode();
        //判断用户之前是否有发送短信验证码,上一次的发送时间与当前时间的间隔是否大于90秒
        if (verfyCode == null || DateUtil.getBetweenTime(verfyCode.getSendTime(),new Date())> BidConst.MESSAGE_INTERVAL_TIME){
            //1.生成验证码
            String verifyCodeUUID = UUID.randomUUID().toString().substring(0, 4);
            //拼接短信内容
            StringBuilder msg = new StringBuilder(50);
            msg.append("这是您的验证码").append(verifyCodeUUID).append(",有效期为").append(BidConst.MESSAGE_VALID_TIME).append("分钟,请尽快使用");
            System.out.println(msg);
            //模拟短信发送
            VerifyCode vo = new VerifyCode();
            vo.setPhoneNumber(phoneNumber);
            vo.setSendTime(new Date());
            vo.setVerifycode(verifyCodeUUID);
            //吧对象放入session中
            UserContext.setVerifyCode(vo);
        }else {
            throw new RuntimeException("操作太频繁了,请稍后再试");
        }
    }

    @Override
    public boolean valid(String phoneNumber, String verifyCode) {
        VerifyCode vo = UserContext.getVerfyCode();
        if(vo != null &&//之前发送过
                vo.getVerifycode().equalsIgnoreCase(verifyCode) &&//验证码和之前产生的一致
                vo.getPhoneNumber().equalsIgnoreCase(phoneNumber) &&//输入的手机号码是之前发送短信的手机号码
                DateUtil.getBetweenTime(vo.getSendTime(),new Date())<=BidConst.MESSAGE_VALID_TIME*60//短信在有效期内
                ){
            return true;
        }
        return false;
    }
}
