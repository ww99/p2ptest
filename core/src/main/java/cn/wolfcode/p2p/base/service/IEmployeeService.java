package cn.wolfcode.p2p.base.service;

import cn.wolfcode.p2p.base.domain.Employee;
import cn.wolfcode.p2p.base.qo.EmployeeQueryObject;
import cn.wolfcode.p2p.base.util.PageResult;

import java.util.List;

/**
 * Created by 123 on 2018/2/10.
 */
public interface IEmployeeService {
    int save(Employee employee);
    int update(Employee employee);
    Employee get(Long id);
    int delete(Long id);
    List<Employee> list();

    PageResult query(EmployeeQueryObject qo);
}
