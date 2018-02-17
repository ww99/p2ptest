package cn.wolfcode.p2p.base.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by 123 on 2018/2/11.
 */
@Getter@Setter
public class PageResult {
    private Long total;
    private List rows;

    public PageResult(Long total,List rows){
        this.total = total;
        this.rows = rows;
    }
}
