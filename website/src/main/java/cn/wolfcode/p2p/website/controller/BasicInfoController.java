package cn.wolfcode.p2p.website.controller;

import cn.wolfcode.p2p.base.domain.Userinfo;
import cn.wolfcode.p2p.base.service.ISystemDictionaryItemService;
import cn.wolfcode.p2p.base.service.IUserinfoService;
import cn.wolfcode.p2p.base.util.AjaxResult;
import cn.wolfcode.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 123 on 2018/2/23.
 */
@Controller
public class BasicInfoController {
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;
    @RequestMapping("basicInfo")
    public String bascinfo(Model model){
        //userinfo
        model.addAttribute("userinfo",userinfoService.get(UserContext.getCurrent().getId()));
        //educationBackgrounds
        model.addAttribute("educationBackgrounds", systemDictionaryItemService.queryListByParentSn("educationBackground"));
        //incomeGrades
        model.addAttribute("incomeGrades", systemDictionaryItemService.queryListByParentSn("incomeGrade"));
        //marriages
        model.addAttribute("marriages", systemDictionaryItemService.queryListByParentSn("marriage"));
        //kidCounts
        model.addAttribute("kidCounts", systemDictionaryItemService.queryListByParentSn("kidCount"));
        //houseConditions
        model.addAttribute("houseConditions", systemDictionaryItemService.queryListByParentSn("houseCondition"));
        return "userInfo";
    }

    @RequestMapping("basicInfo_save")
    @ResponseBody
    public AjaxResult bascinfoSave(Userinfo userinfo){
        AjaxResult result = null;
        try {
            userinfoService.basicInfoSave(userinfo);
            result = new AjaxResult("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("保存失败",false);
        }
        return result;
    }
}
