package cn.wolfcode.p2p.base.util;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 123 on 2018/2/12.
 */
@Getter@Setter
public class AjaxResult {
    private String msg;
    private boolean success=true;

    public AjaxResult(String msg){
        this.msg = msg;
    }
    public AjaxResult(String msg,boolean success){
        this.msg = msg;
        this.success = success;
    }
}
