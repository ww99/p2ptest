package cn.wolfcode.p2p.mgrsite.controller;

import cn.wolfcode.p2p.base.domain.SystemDictionary;
import cn.wolfcode.p2p.base.qo.SystemDictionaryQueryObject;
import cn.wolfcode.p2p.base.service.ISystemDictionaryService;
import cn.wolfcode.p2p.base.util.AjaxResult;
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

    @RequestMapping("systemDictionary_save")
    @ResponseBody
    public AjaxResult save(SystemDictionary systemDictionary){
        AjaxResult result = null;
        try {
            systemDictionaryService.save(systemDictionary);
            result = new AjaxResult("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("添加失败",false);
        }
        return result;
    }

    @RequestMapping("systemDictionary_update")
    @ResponseBody
    public AjaxResult update(SystemDictionary systemDictionary){
        AjaxResult result = null;
        try {
            systemDictionaryService.update(systemDictionary);
            result = new AjaxResult("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("修改失败",false);
        }
        return result;
    }
}
