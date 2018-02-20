package cn.wolfcode.p2p.base.mapper;

import cn.wolfcode.p2p.base.domain.IpLog;
import cn.wolfcode.p2p.base.qo.IpLogQueryObjecrt;

import java.util.List;

public interface IpLogMapper {
    int insert(IpLog record);
    List<IpLog> selectAll();

    List<IpLog> queryPage(IpLogQueryObjecrt qo);
}