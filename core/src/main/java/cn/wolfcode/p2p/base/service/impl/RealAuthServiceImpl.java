package cn.wolfcode.p2p.base.service.impl;

import cn.wolfcode.p2p.base.domain.Logininfo;
import cn.wolfcode.p2p.base.domain.RealAuth;
import cn.wolfcode.p2p.base.domain.Userinfo;
import cn.wolfcode.p2p.base.mapper.RealAuthMapper;
import cn.wolfcode.p2p.base.mapper.UserinfoMapper;
import cn.wolfcode.p2p.base.qo.RealAuthQueryObject;
import cn.wolfcode.p2p.base.service.IRealAuthService;
import cn.wolfcode.p2p.base.util.BitStatesUtils;
import cn.wolfcode.p2p.base.util.PageResult;
import cn.wolfcode.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
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

    @Override
    public PageResult query(RealAuthQueryObject qo) {
        Long total = realAuthMapper.queryForCount();
        if (total == 0){
            return new PageResult(total, Collections.EMPTY_LIST);
        }
        List<RealAuth> realAuths = realAuthMapper.queryForList(qo);
        System.out.println(realAuths);
        return new PageResult(total,realAuthMapper.queryForList(qo));
    }

    @Override
    public void audit(Long id, int state, String remark) {
        //根据id查询实名认证审核对象,判断是否为null
        RealAuth auth = realAuthMapper.selectByPrimaryKey(id);
        if (auth != null && auth.getState() == RealAuth.STATE_NORMAL){
            //设置审核人,审核时间,审核备注
            Logininfo auditor = new Logininfo();
            Logininfo current = UserContext.getCurrent();
            System.out.println(current);
            auditor.setId(UserContext.getCurrent().getId());
            auth.setAuditor(auditor);
            auth.setAuditTime(new Date());
            auth.setRemark(remark);
            //获取申请的userinfo对象
            Userinfo userinfo = userinfoMapper.selectByPrimaryKey(auth.getApplier().getId());
            //审核通过
            if (state == RealAuth.STATE_PASS){
                //状态修改为审核通过
                auth.setState(RealAuth.STATE_PASS);
                //给申请人的userininfo添加实名认证状态码
                userinfo.addState(BitStatesUtils.OP_REAL_AUTH);
                //设置申请人userinfo中的idNumber,realName
                userinfo.setRealName(auth.getRealName());
                userinfo.setIdNumber(auth.getIdNumber());
            }else {
                //审核拒绝
                // 状态码修改为审核拒绝
                auth.setState(RealAuth.STATE_REJECT);
                //设置申请人userninfo中的realAuthId为null
                userinfo.setRealAuthId(null);
            }
            userinfoMapper.updateByPrimaryKey(userinfo);
            realAuthMapper.updateByPrimaryKey(auth);

        }
    }
}
