package cn.wolfcode.p2p.base.service.impl;

import cn.wolfcode.p2p.base.domain.MailVerify;
import cn.wolfcode.p2p.base.domain.Userinfo;
import cn.wolfcode.p2p.base.mapper.UserinfoMapper;
import cn.wolfcode.p2p.base.service.IMailVerifyService;
import cn.wolfcode.p2p.base.service.IUserinfoService;
import cn.wolfcode.p2p.base.service.IVerifyCodeService;
import cn.wolfcode.p2p.base.util.BidConst;
import cn.wolfcode.p2p.base.util.BitStatesUtils;
import cn.wolfcode.p2p.base.util.DateUtil;
import cn.wolfcode.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by 123 on 2018/2/18.
 */
@Service@Transactional
public class UserinfoServiceImpl implements IUserinfoService{
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Autowired
    private IVerifyCodeService verifyCodeService;
    @Autowired
    private IMailVerifyService mailVerifyService;
    @Override
    public int save(Userinfo userinfo) {
        return userinfoMapper.insert(userinfo);
    }

    @Override
    public int update(Userinfo userinfo) {
        return userinfoMapper.updateByPrimaryKey(userinfo);
    }

    @Override
    public Userinfo get(Long id) {
        return userinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void bindPhone(String phoneNumber, String verifyCode) {
        //1.验证码是否有效,手机号码是否是发送短信的手机号码,验证码在有效时间内
        boolean isValid = verifyCodeService.valid(phoneNumber, verifyCode);
        if(!isValid){
            throw new RuntimeException("验证码有误,请重新发送");
        }
        //2.判断用户是否已经绑定手机
        Userinfo userinfo = this.get(UserContext.getCurrent().getId());
        if (userinfo.getHasBindPhone()){
            throw new RuntimeException("您已经绑定手机,请不要重复绑定");
        }
        //3.给用户的userinfo添加手机认证的状态码
        userinfo.addState(BitStatesUtils.OP_BIND_PHONE);
        userinfo.setPhoneNumber(phoneNumber);
        this.update(userinfo);


    }

    @Override
    public void bindEmail(String key) {
        //根据uuid查询记录
        MailVerify mailVerify = mailVerifyService.get(key);
        if (mailVerify == null){
            throw new RuntimeException("验证邮件地址有误,请重新发送");
        }
        //判断邮箱是否在有效期内
        if(DateUtil.getBetweenTime(new Date(),mailVerify.getSendTime())> BidConst.EMAIL_VALID_TIME*24*60*60){
            throw new RuntimeException("验证邮箱已经失效,请重新发送");
        }
        //判断用户是否已经绑定邮箱
        Userinfo userinfo = this.get(mailVerify.getUserId());
        if (userinfo.getHasBindEmail()){
            throw new RuntimeException("您已经绑定邮箱,请不要重复绑定");
        }
        //给用户添加邮箱验证的状态码
        userinfo.addState(BitStatesUtils.OP_BIND_EMAIL);
        //给userinfo中的email设置值
        userinfo.setEmail(mailVerify.getEmail());
        //更新useinfo
        this.update(userinfo);
    }

    @Override
    public void basicInfoSave(Userinfo userinfo) {
        Userinfo currentUserinfo = userinfoMapper.selectByPrimaryKey(UserContext.getCurrent().getId());
        currentUserinfo.setEducationBackground(userinfo.getEducationBackground());
        currentUserinfo.setHouseCondition(userinfo.getHouseCondition());
        currentUserinfo.setIncomeGrade(userinfo.getIncomeGrade());
        currentUserinfo.setKidCount(userinfo.getKidCount());
        currentUserinfo.setMarriage(userinfo.getMarriage());
        if(!userinfo.getIsBasicInfo()){
            currentUserinfo.addState(BitStatesUtils.OP_BASIC_INFO);
        }
        userinfoMapper.updateByPrimaryKey(currentUserinfo);
    }
}
