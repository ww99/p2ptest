package cn.wolfcode.p2p.mgrsite.controller;

import cn.wolfcode.p2p.base.qo.RealAuthQueryObject;
import cn.wolfcode.p2p.base.service.IRealAuthService;
import cn.wolfcode.p2p.base.util.AjaxResult;
import cn.wolfcode.p2p.base.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 123 on 2018/2/23.
 */
@Controller
public class RealAuthController {
    @Autowired
    private IRealAuthService realAuthService;
    @RequestMapping("/realAuth")
    public String realAuth(){
        return "realAuth/list";
    }

    @RequestMapping("/realAuth_data")
    @ResponseBody
    public PageResult data(RealAuthQueryObject qo){
        PageResult query = realAuthService.query(qo);
        return query;
    }
    @RequestMapping("audit")
    @ResponseBody
    public AjaxResult audit(Long id,int state,String remark){
        AjaxResult result = null;
        try {
            System.out.println(id);
            System.out.println(state);
            System.out.println(remark);
            realAuthService.audit(id,state,remark);
            result = new AjaxResult("审核成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("审核失败",false);
        }
        return result;
    }
}
