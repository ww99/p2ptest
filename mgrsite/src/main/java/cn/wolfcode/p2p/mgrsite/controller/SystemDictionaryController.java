package cn.wolfcode.p2p.mgrsite.controller;

import cn.wolfcode.p2p.base.qo.SystemDictionaryQueryObject;
import cn.wolfcode.p2p.base.service.ISystemDictionaryService;
import cn.wolfcode.p2p.base.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 123 on 2018/2/20.
 */
@Controller
public class SystemDictionaryController {
    @Autowired
    private ISystemDictionaryService systemDictionaryService;
    @RequestMapping("systemDictionary_list")
    public String list(){
        return "systemdic/systemDictionary_list";
    }

    @RequestMapping("systemDictionary_data")
    @ResponseBody
    public PageResult systemDictionaryData(SystemDictionaryQueryObject qo){
        return systemDictionaryService.query(qo);
    }
}
