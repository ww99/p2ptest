package cn.wolfcode.p2p.base.service;

import cn.wolfcode.p2p.base.domain.IpLog;
import cn.wolfcode.p2p.base.qo.IpLogQueryObjecrt;
import com.github.pagehelper.PageInfo;

/**
 * Created by 123 on 2018/2/18.
 */
public interface IIpLogService {
    int save(IpLog ipLog);

    PageInfo queryPage(IpLogQueryObjecrt qo);
}
