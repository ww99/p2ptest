package cn.wolfcode.p2p.website.controller;

import cn.wolfcode.p2p.base.service.IEmailService;
import cn.wolfcode.p2p.base.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 123 on 2018/2/22.
 */
@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;
    @RequestMapping("sendEmail")
    @ResponseBody
    public AjaxResult sendEmail(String email){
        AjaxResult result = null;
        try {
            emailService.sendEmail(email);
            result = new AjaxResult("发送邮件成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("发送邮件失败");
        }
        return result;
    }
}
