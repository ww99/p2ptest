package cn.wolfcode.p2p.website.controller;

import cn.wolfcode.p2p.base.qo.IpLogQueryObjecrt;
import cn.wolfcode.p2p.base.service.IIpLogService;
import cn.wolfcode.p2p.base.util.UserContext;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 123 on 2018/2/
 * 18.
 */
@Controller
public class IpLogController {
    @Autowired
    private IIpLogService ipLogService;
    @RequestMapping("/ipLog")
    public String iplog(Model model, @ModelAttribute("qo") IpLogQueryObjecrt qo){
        qo.setUsername(UserContext.getCurrent().getUsername());
        PageInfo pageInfo = ipLogService.queryPage(qo);
        model.addAttribute("pageResult",pageInfo);
        return "ipLog_list";
    }
}
