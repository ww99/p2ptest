package cn.wolfcode.p2p.base.service.impl;

import cn.wolfcode.p2p.base.domain.Account;
import cn.wolfcode.p2p.base.domain.IpLog;
import cn.wolfcode.p2p.base.domain.Logininfo;
import cn.wolfcode.p2p.base.domain.Userinfo;
import cn.wolfcode.p2p.base.mapper.LogininfoMapper;
import cn.wolfcode.p2p.base.service.IAccountService;
import cn.wolfcode.p2p.base.service.IIpLogService;
import cn.wolfcode.p2p.base.service.ILogininfoService;
import cn.wolfcode.p2p.base.service.IUserinfoService;
import cn.wolfcode.p2p.base.util.BidConst;
import cn.wolfcode.p2p.base.util.MD5;
import cn.wolfcode.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by 123 on 2018/2/18.
 */
@Service@Transactional
public class LogininfoServiceImpl implements ILogininfoService{

    @Autowired
    private LogininfoMapper logininfoMapper;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private IIpLogService ipLogService;
    @Override
    public int save(Logininfo logininfo) {
        return logininfoMapper.insert(logininfo);
    }

    @Override
    public Logininfo login(String username, String password, int userType) {
        Logininfo logininfo = logininfoMapper.selectUser(username, MD5.encode(password),userType);
        IpLog iplog = new IpLog();
        iplog.setUsername(username);
        iplog.setLoginTime(new Date());
        iplog.setIp(UserContext.getIp());
        if (logininfo != null){
            //存在改用户,存入session
            iplog.setState(IpLog.LOGIN_SUCCESS);
            UserContext.setCurrent(logininfo);
        }else {
            //不存在该用户.抛出异常
            iplog.setState(IpLog.LOGIN_FAILED);
        }
        ipLogService.save(iplog);
        return logininfo;
    }

    @Override
    public Logininfo register(String username, String password) {
        //判断该用户是否存在
        int count = logininfoMapper.selectCountByName(username);
        if (count > 0){
            throw new RuntimeException("该账号已存在");
        }
        //不存在,保存入库
        Logininfo logininfo = new Logininfo();
        logininfo.setUsername(username);
        logininfo.setPassword(MD5.encode(password));
        logininfo.setState(Logininfo.STATE_NORMAL);
        logininfo.setUserType(Logininfo.USERTYPE_USER);
        logininfoMapper.insert(logininfo);

        Account account = new Account();
        account.setId(logininfo.getId());
        accountService.save(account);

        Userinfo userinfo = new Userinfo();
        userinfo.setId(logininfo.getId());
        userinfoService.save(userinfo);

        return logininfo;
    }

    @Override
    public void initAdmin() {
        //根基类型去数据库中查找是否有管理员
        int count = logininfoMapper.queryCountByUserType(Logininfo.USERTYPE_MANAGER);
        //如果没有,创建一个管理员
        if (count == 0){
            Logininfo logininfo = new Logininfo();
            logininfo.setState(Logininfo.STATE_NORMAL);
            logininfo.setUsername(BidConst.ADMIN_ACCOUNT);
            logininfo.setUserType(Logininfo.USERTYPE_MANAGER);
            logininfo.setPassword(MD5.encode(BidConst.ADMIN_PASSWORD));
            logininfoMapper.insert(logininfo);
        }
    }
}
