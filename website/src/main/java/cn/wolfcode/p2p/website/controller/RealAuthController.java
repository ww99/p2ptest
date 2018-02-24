package cn.wolfcode.p2p.website.controller;

import cn.wolfcode.p2p.base.domain.RealAuth;
import cn.wolfcode.p2p.base.domain.Userinfo;
import cn.wolfcode.p2p.base.service.IRealAuthService;
import cn.wolfcode.p2p.base.service.IUserinfoService;
import cn.wolfcode.p2p.base.util.AjaxResult;
import cn.wolfcode.p2p.base.util.UserContext;
import cn.wolfcode.p2p.website.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 123 on 2018/2/22.
 */
@Controller
public class RealAuthController {
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private IRealAuthService realAuthService;
    @Value("${file.path}")
    private String filePath;
    @RequestMapping("realAuth")
    public String realAuth(Model model){
        //获取userinfo对象,判断当前用户是否拥有实名认证状态码
        Userinfo userinfo = userinfoService.get(UserContext.getCurrent().getId());
        if (userinfo.getIsRealAuth()){
            //如果有,根据userininfo中的realAuthId查询对应的实名认证对象跳转到结果页面
            RealAuth auth = realAuthService.get(userinfo.getRealAuthId());
            model.addAttribute("realAuth",auth);
            model.addAttribute("auditing",false);
            return "realAuth_result";
        }else {
            //如果没有
            //判断userinfo中的realAuthId是否为null
            if (userinfo.getRealAuthId() == null){
                //如果为null,跳转到申请页面(realAuth.ftl) 审核拒绝
                return "realAuth";
            }else {
                //如果不为null,跳转到realAuth_result.ftl 待审核
                model.addAttribute("auditing",true);
                return "realAuth_result";
            }
        }
    }

    @RequestMapping("realAuth_save")
    @ResponseBody
    public AjaxResult realAuthSave(RealAuth realAuth){
        AjaxResult result = null;
        try {
            realAuthService.realAuthSave(realAuth);
            result = new AjaxResult("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("操作失败",false);
        }
        return result;
    }
    @RequestMapping("uploadImage")
    @ResponseBody
    public String uploadImage(MultipartFile image){
        return UploadUtil.upload(image,filePath);
    }
}
