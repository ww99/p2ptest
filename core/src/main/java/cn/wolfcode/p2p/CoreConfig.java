package cn.wolfcode.p2p;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Created by 123 on 2018/2/10.
 */
@Configuration
@PropertySources({
        @PropertySource("classpath:application-core.properties"),
        @PropertySource("classpath:email.properties")
})
@MapperScan({"cn.wolfcode.p2p.base.mapper","cn.wolfcode.p2p.business.mapper"})
public class CoreConfig {
}
