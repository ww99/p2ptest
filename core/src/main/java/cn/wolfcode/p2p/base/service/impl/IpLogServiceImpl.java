package cn.wolfcode.p2p.base.service.impl;

import cn.wolfcode.p2p.base.domain.IpLog;
import cn.wolfcode.p2p.base.mapper.IpLogMapper;
import cn.wolfcode.p2p.base.qo.IpLogQueryObjecrt;
import cn.wolfcode.p2p.base.service.IIpLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 123 on 2018/2/18.
 */
@Service@Transactional
public class IpLogServiceImpl implements IIpLogService{

    @Autowired
    private IpLogMapper ipLogMapper;
    @Override
    public int save(IpLog ipLog) {
        return ipLogMapper.insert(ipLog);
    }

    @Override
    public PageInfo queryPage(IpLogQueryObjecrt qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        List<IpLog> list = ipLogMapper.queryPage(qo);
        return new PageInfo(list);
    }
}
