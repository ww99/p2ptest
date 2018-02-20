package cn.wolfcode.p2p.business.domain;

import cn.wolfcode.p2p.base.domain.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2018/2/20.
 */
@Getter@Setter
public class SystemMenu extends BaseDomain {
    private String text;
    private String iconCls;
    private String url;
    private Long parent_id;
    private List<SystemMenu> children = new ArrayList<SystemMenu>();
    public Map<String,Object> getAttributes(){
        Map<String,Object> attributes = new HashMap<String,Object>();
        attributes.put("url", url);
        return attributes;
    }
}
