package cn.wolfcode.p2p.base.qo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 123 on 2018/2/11.
 */
@Getter@Setter
public class QueryObject {
    private int currentPage=1;
    private int pageSize=10;

    public int getStart(){
        return (currentPage - 1) * pageSize;
    }
}
