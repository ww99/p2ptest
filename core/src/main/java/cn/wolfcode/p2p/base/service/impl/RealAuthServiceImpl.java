package cn.wolfcode.p2p.base.service.impl;

import cn.wolfcode.p2p.base.domain.RealAuth;
import cn.wolfcode.p2p.base.domain.Userinfo;
import cn.wolfcode.p2p.base.mapper.RealAuthMapper;
import cn.wolfcode.p2p.base.mapper.UserinfoMapper;
import cn.wolfcode.p2p.base.service.IRealAuthService;
import cn.wolfcode.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by 123 on 2018/2/23.
 */
@Service@Transactional
public class RealAuthServiceImpl implements IRealAuthService{
    @Autowired
    private RealAuthMapper realAuthMapper;
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Override
    public int save(RealAuth realAuth) {
        return realAuthMapper.insert(realAuth);
    }

    @Override
    public int update(RealAuth realAuth) {
        return realAuthMapper.updateByPrimaryKey(realAuth);
    }

    @Override
    public RealAuth get(Long id) {
        return realAuthMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<RealAuth> list() {
        return realAuthMapper.selectAll();
    }

    @Override
    public void realAuthSave(RealAuth realAuth) {
        //把实名认证信息存入数据库
        RealAuth auth = new RealAuth();
        auth.setRealName(realAuth.getRealName());//真实姓名
        auth.setApplier(UserContext.getCurrent());//申请人
        auth.setSex(realAuth.getSex());//性别
        auth.setIdNumber(realAuth.getIdNumber());//身份证号
        auth.setImage1(realAuth.getImage1());//身份证正面图片地址
        auth.setImage2(realAuth.getImage2());//身份证反面图片地址
        auth.setBirthDate(realAuth.getBirthDate());//出身年月
        auth.setAddress(realAuth.getAddress());//地址
        auth.setApplyTime(new Date());//申请时间
        auth.setState(RealAuth.STATE_NORMAL);//状态:待审核
        realAuthMapper.insert(auth);
        //设置userinfo中的realAuth字段
        Userinfo userinfo = userinfoMapper.selectByPrimaryKey(UserContext.getCurrent().getId());
        userinfo.setRealAuthId(auth.getId());
        userinfoMapper.updateByPrimaryKey(userinfo);
    }
}
