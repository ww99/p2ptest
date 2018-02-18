package cn.wolfcode.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 123 on 2018/2/18.
 */
@Controller
public class PersonalController {
    @RequestMapping("personal")
    public String personal(Model model){
        return "personal";
    }
}
