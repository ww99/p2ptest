package cn.wolfcode.p2p.mgrsite.controller;

import cn.wolfcode.p2p.base.domain.Employee;
import cn.wolfcode.p2p.base.qo.EmployeeQueryObject;
import cn.wolfcode.p2p.base.service.IEmployeeService;
import cn.wolfcode.p2p.base.util.AjaxResult;
import cn.wolfcode.p2p.base.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 123 on 2018/2/10.
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @RequestMapping("list")
    public String employeeList(){
        return "employee/list";
    }

    @RequestMapping("employeeList")
    @ResponseBody
    public PageResult employeeDate(EmployeeQueryObject qo){
        return employeeService.query(qo);
    }
    @RequestMapping("employeeSave")
    @ResponseBody
    public AjaxResult save(Employee employee){
        AjaxResult result = null;
        try {
            employeeService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(e.getMessage());
        }
        return new AjaxResult("保存成功",true);
    }

    @RequestMapping("employeeUpdate")
    @ResponseBody
    public AjaxResult update(Employee employee){
        AjaxResult result = null;
        try {
            employeeService.update(employee);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(e.getMessage());
        }
        return new AjaxResult("编辑成功",true);
    }

}
