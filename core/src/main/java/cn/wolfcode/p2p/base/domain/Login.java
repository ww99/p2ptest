package cn.wolfcode.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 123 on 2018/2/14.
 */
@Getter@Setter
public class Login extends BaseDomain{
    public static final int STATE_NORMAL = 0;//正常状态
    public static final int STATE_LOCK = 1;//锁定状态

    private String userName;
    private String password;
    private int state;
}
