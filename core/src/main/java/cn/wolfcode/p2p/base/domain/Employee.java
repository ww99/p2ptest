package cn.wolfcode.p2p.base.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by 123 on 2018/2/10.
 */
@Getter@Setter
public class Employee extends BaseDomain{
    private String userName;
    private int age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm",timezone = "GTM+8")
    private Date hireDate;
}
