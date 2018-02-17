package cn.wolfcode.p2p.base.mapper;

import cn.wolfcode.p2p.base.domain.Employee;
import cn.wolfcode.p2p.base.qo.EmployeeQueryObject;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee employee);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee employee);

    Long queryForCount();

    List queryForList(EmployeeQueryObject qo);
}