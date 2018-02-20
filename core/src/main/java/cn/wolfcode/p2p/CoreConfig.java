package cn.wolfcode.p2p;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by 123 on 2018/2/10.
 */
@Configuration
@PropertySource("classpath:application.properties")
@MapperScan({"cn.wolfcode.p2p.base.mapper","cn.wolfcode.p2p.business.mapper"})
public class CoreConfig {
}
