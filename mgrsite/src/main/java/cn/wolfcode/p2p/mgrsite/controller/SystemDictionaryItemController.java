package cn.wolfcode.p2p.mgrsite.controller;

import cn.wolfcode.p2p.base.domain.SystemDictionary;
import cn.wolfcode.p2p.base.domain.SystemDictionaryItem;
import cn.wolfcode.p2p.base.qo.SystemDictionaryItemQueryObject;
import cn.wolfcode.p2p.base.service.ISystemDictionaryItemService;
import cn.wolfcode.p2p.base.util.AjaxResult;
import cn.wolfcode.p2p.base.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 123 on 2018/2/22.
 */
@Controller
public class SystemDictionaryItemController {
    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;
    @RequestMapping("systemDictionaryItem_list")
    public String systemDictionaryItemList(){
        return "systemdic/systemDictionaryItem_list";
    }
    @RequestMapping("systemDictionaryItem_data")
    @ResponseBody
    public PageResult systemDictionaryItemData(SystemDictionaryItemQueryObject qo){
        System.out.println(qo.getParentId());
        return systemDictionaryItemService.query(qo);
    }

    @RequestMapping("systemDictionaryItem_save")
    @ResponseBody
    public AjaxResult save(SystemDictionaryItem systemDictionaryItem){
        AjaxResult result = null;
        try {
            systemDictionaryItemService.save(systemDictionaryItem);
            result = new AjaxResult("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("保存失败",false);
        }
        return result;
    }
    @RequestMapping("systemDictionaryItem_update")
    @ResponseBody
    public AjaxResult update(SystemDictionaryItem systemDictionaryItem){
        AjaxResult result = null;
        try {
            systemDictionaryItemService.update(systemDictionaryItem);
            result = new AjaxResult("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("修改失败",false);
        }
        return result;
    }
    @RequestMapping("selectParentId")
    @ResponseBody
    public List<SystemDictionary> selectParentId(){
        return systemDictionaryItemService.selectParent();
    }

}
