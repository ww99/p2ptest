package cn.wolfcode.p2p.website.controller;

import cn.wolfcode.p2p.base.domain.Logininfo;
import cn.wolfcode.p2p.base.service.ILogininfoService;
import cn.wolfcode.p2p.base.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 123 on 2018/2/18.
 */
@Controller
public class RegisterController {
    @Autowired
    private ILogininfoService logininfoService;
    @RequestMapping("userLogin")
    @ResponseBody
    public AjaxResult login(String username,String password){
        AjaxResult result = null;
        Logininfo logininfo = logininfoService.login(username,password,Logininfo.USERTYPE_USER);
        if (logininfo == null){
            result = new AjaxResult("密码输入有误",false);
        }else {
            result = new AjaxResult("登录成功");
        }
        return result;
    }
    @RequestMapping("userRegister")
    @ResponseBody
    public AjaxResult userRegister(String username,String password){
        AjaxResult result = null;
        try {
            logininfoService.register(username,password);
            result = new AjaxResult("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(e.getMessage(),false);
        }
        return result;
    }
}
