package cn.wolfcode.p2p.base.domain;

import cn.wolfcode.p2p.base.util.BitStatesUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by 123 on 2018/2/18.
 */
@Getter@Setter
public class Userinfo extends BaseDomain{
    private int version;//版本号，用作乐观锁
    private long bitState = 0;//用户状态值
    private String realName;//用户实名值（冗余数据）
    private String idNumber;//用户身份证号（冗余数据）
    private String phoneNumber;//用户电话
    private String email;//电子邮箱
    private int score;//当前用户已经审核通过的风控材料评分
    private Long realAuthId;//实名认证id
    private SystemDictionaryItem incomeGrade;//收入
    private SystemDictionaryItem marriage;//婚姻情况
    private SystemDictionaryItem kidCount;//子女情况
    private SystemDictionaryItem educationBackground;//学历
    private SystemDictionaryItem houseCondition;//住房条件

    //手机短信验证
    public boolean getHasBindPhone(){
        return BitStatesUtils.hasState(this.bitState,BitStatesUtils.OP_BIND_PHONE);
    }
    //邮箱认证
    public boolean getHasBindEmail(){
        return BitStatesUtils.hasState(this.bitState,BitStatesUtils.OP_BIND_EMAIL);
    }
    //基本信息
    public boolean getIsBasicInfo(){
        return BitStatesUtils.hasState(this.bitState,BitStatesUtils.OP_BASIC_INFO);
    }
    //实名认证
    public boolean getIsRealAuth(){
        return BitStatesUtils.hasState(this.bitState,BitStatesUtils.OP_REAL_AUTH);
    }
    //视频认证
    public boolean getIsVedioAuth(){
        return BitStatesUtils.hasState(this.bitState,BitStatesUtils.OP_VEDIO_AUTH);
    }
    public boolean getIsBidRequestProcess(){
        return BitStatesUtils.hasState(this.bitState,BitStatesUtils.OP_HAS_BIDREQUEST_PROCESS);
    }
    //添加状态码
    public void addState(Long state) {
        this.bitState = BitStatesUtils.addState(state,this.bitState);
    }
    public void removeState(Long state) {
        this.bitState = BitStatesUtils.removeState(state,this.bitState);
    }
}
