package cn.wolfcode.p2p.base.mapper;

import cn.wolfcode.p2p.base.domain.Logininfo;
import org.apache.ibatis.annotations.Param;

public interface LogininfoMapper {
    int insert(Logininfo logininfo);

    Logininfo selectUser(@Param("username") String username, @Param("password") String password, @Param("userType") int userType);

    int selectCountByName(String username);
}