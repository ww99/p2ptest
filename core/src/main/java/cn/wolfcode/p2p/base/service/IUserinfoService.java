package cn.wolfcode.p2p.base.service;

import cn.wolfcode.p2p.base.domain.Userinfo;

/**
 * Created by 123 on 2018/2/18.
 */
public interface IUserinfoService {
    int save(Userinfo userinfo);
    int update(Userinfo userinfo);
    Userinfo get(Long id);

    /**
     * 手机绑定
     * @param phoneNumber
     * @param verifyCode
     */
    void bindPhone(String phoneNumber, String verifyCode);

    /**
     * 邮箱绑定
     * @param key
     */
    void bindEmail(String key);

    /**
     * 保存基本信息
     * @param userinfo
     */
    void basicInfoSave(Userinfo userinfo);

}
