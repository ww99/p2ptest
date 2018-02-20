package cn.wolfcode.p2p.business.qo;

import cn.wolfcode.p2p.base.qo.QueryObject;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by 123 on 2018/2/20.
 */
@Getter@Setter
public class SystemMenuQueryObject extends QueryObject{
    private Long parentId;
}
