package cn.wolfcode.p2p.base.service;

/**
 * Created by 123 on 2018/2/21.
 */
public interface IVerifyCodeService {
    /**
     * 发送和短信功能
     * @param phoneNumber
     */
    void sendVerifyCode(String phoneNumber);

    /**
     * 验证码校验
     * @param phoneNumber
     * @param verifyCode
     * @return
     */
    boolean valid(String phoneNumber,String verifyCode);
}
