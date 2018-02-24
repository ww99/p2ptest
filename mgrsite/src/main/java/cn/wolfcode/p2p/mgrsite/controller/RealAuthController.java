package cn.wolfcode.p2p.mgrsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 123 on 2018/2/23.
 */
@Controller
public class RealAuthController {
    @RequestMapping("/realAuth")
    public String realAuth(){
        return "realAuth/list";
    }
}
