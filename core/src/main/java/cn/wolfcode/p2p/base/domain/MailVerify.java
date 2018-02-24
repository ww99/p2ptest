package cn.wolfcode.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by 123 on 2018/2/22.
 */
@Getter@Setter
public class MailVerify extends BaseDomain{
    private String email;
    private Long userId;
    private Date sendTime;
    private String uuid;
}
