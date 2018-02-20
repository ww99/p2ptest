package cn.wolfcode.p2p.base.service.impl;

import cn.wolfcode.p2p.base.domain.Employee;
import cn.wolfcode.p2p.base.mapper.EmployeeMapper;
import cn.wolfcode.p2p.base.qo.EmployeeQueryObject;
import cn.wolfcode.p2p.base.service.IEmployeeService;
import cn.wolfcode.p2p.base.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Created by 123 on 2018/2/10.
 */
@Service@Transactional
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public int save(Employee employee) {

        return employeeMapper.insert(employee);
    }

    @Override
    public int update(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public Employee get(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Employee> list() {
        return employeeMapper.selectAll();
    }

    @Override
    public PageResult query(EmployeeQueryObject qo) {
        Long total = employeeMapper.queryForCount();
        if (total == 0){
            return new PageResult(total, Collections.EMPTY_LIST);
        }
        return new PageResult(total,employeeMapper.queryForList(qo));
    }
}

