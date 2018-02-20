package cn.wolfcode.p2p.website.controller;

import cn.wolfcode.p2p.base.service.IAccountService;
import cn.wolfcode.p2p.base.service.IUserinfoService;
import cn.wolfcode.p2p.base.util.UserContext;
import cn.wolfcode.p2p.website.util.RequireLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 123 on 2018/2/18.
 */
@Controller
public class PersonalController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserinfoService userinfoService;
    @RequireLogin
    @RequestMapping("personal")
    public String personal(Model model){
        model.addAttribute("account",accountService.get(UserContext.getCurrent().getId()));
        model.addAttribute("userinfo",userinfoService.get(UserContext.getCurrent().getId()));
        return "personal";
    }
}
