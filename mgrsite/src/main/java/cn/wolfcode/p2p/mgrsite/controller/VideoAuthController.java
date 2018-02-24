package cn.wolfcode.p2p.mgrsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 123 on 2018/2/24.
 */
@Controller
public class VideoAuthController {
    @RequestMapping("videoAuth")
    public String videoAuth(){
        return "videoAuth/list";
    }
}
