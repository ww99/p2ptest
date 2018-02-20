package cn.wolfcode.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by 123 on 2018/2/18.
 */
@Getter@Setter
public class IpLog extends BaseDomain{
    public static final int LOGIN_SUCCESS=0;
    public static final int LOGIN_FAILED = 1;
    private String ip;
    private String username;
    private Date loginTime;
    private int state;
    //private int userType;
    public String getStateDisplay(){
        return this.state == LOGIN_SUCCESS ? "登录成功":"登录失败";
    }
}
