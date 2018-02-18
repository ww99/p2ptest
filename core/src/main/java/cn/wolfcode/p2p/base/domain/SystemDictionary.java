package cn.wolfcode.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 123 on 2018/2/18.
 */
@Getter@Setter
public class SystemDictionary extends BaseDomain {
    private String title;//分类名称,如:教育背景
    private String sn;//分类编码 ,如:educationBackground
}
