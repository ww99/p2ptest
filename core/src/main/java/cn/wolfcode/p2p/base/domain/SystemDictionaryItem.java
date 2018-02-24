package cn.wolfcode.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 123 on 2018/2/18.
 */
@Getter@Setter
public class SystemDictionaryItem extends BaseDomain{
    private SystemDictionary parent;//分类ID
    private String title;//名称
    private int sequence;//顺序

    /*public String getJsonString(){
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("id",id);
        params.put("parentId",parentId);
        params.put("title",title);
        params.put("sequence",sequence);
        return JSON.toJSONString(params);
    }*/
}
