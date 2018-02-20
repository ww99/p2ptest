package cn.wolfcode.p2p.mgrsite.listener;

import cn.wolfcode.p2p.base.service.ILogininfoService;
import cn.wolfcode.p2p.business.service.ISystemAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by 123 on 2018/2/19.
 */
@Component
public class InitAdminListener implements ApplicationListener<ContextRefreshedEvent>{
    @Autowired
    private ISystemAccountService systemAccountService;
    @Autowired
    private ILogininfoService logininfoService;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logininfoService.initAdmin();
        systemAccountService.initAccount();
    }
}
