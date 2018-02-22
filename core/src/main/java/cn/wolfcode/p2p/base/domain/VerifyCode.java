package cn.wolfcode.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 123 on 2018/2/21.
 */
@Getter@Setter
public class VerifyCode implements Serializable{
    private String phoneNumber;
    private String verifycode;
    private Date sendTime;
}
