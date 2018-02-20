package cn.wolfcode.p2p.mgrsite.controller;

import cn.wolfcode.p2p.business.domain.SystemMenu;
import cn.wolfcode.p2p.business.service.ISystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 123 on 2018/2/20.
 */
@Controller
@RequestMapping("systemMenu")
public class SystemMenuController {
    @Autowired
    private ISystemMenuService systemMenuService;
    @RequestMapping("indexMenu")
    @ResponseBody
    public List<SystemMenu> indexMenu(){
        List<SystemMenu> result = systemMenuService.list();
        return result;
    }
}
