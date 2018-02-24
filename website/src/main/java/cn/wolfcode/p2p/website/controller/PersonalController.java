package cn.wolfcode.p2p.website.controller;

import cn.wolfcode.p2p.base.service.IAccountService;
import cn.wolfcode.p2p.base.service.IUserinfoService;
import cn.wolfcode.p2p.base.service.IVerifyCodeService;
import cn.wolfcode.p2p.base.util.AjaxResult;
import cn.wolfcode.p2p.base.util.UserContext;
import cn.wolfcode.p2p.website.util.RequireLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 123 on 2018/2/18.
 */
@Controller
public class PersonalController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private IVerifyCodeService verifyCodeService;
    @RequireLogin
    @RequestMapping("personal")
    public String personal(Model model){
        model.addAttribute("account",accountService.get(UserContext.getCurrent().getId()));
        model.addAttribute("userinfo",userinfoService.get(UserContext.getCurrent().getId()));
        return "personal";
    }

    @RequestMapping("bindPhone")
    @ResponseBody
    public AjaxResult bindPhone(String phoneNumber,String verifyCode){
        AjaxResult result = null;
        try {
            userinfoService.bindPhone(phoneNumber,verifyCode);
            result = new AjaxResult("验证成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("验证失败");
        }
        return result;
    }

    @RequestMapping("bindEmail")
    public String bindEmail(String key,Model model){
        try {
            System.out.println(key);
            userinfoService.bindEmail(key);
            model.addAttribute("success",true);
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("success",false);
            model.addAttribute("msg",e.getMessage());
        }
        return "checkmail_result";
    }
}
