package cn.wolfcode.p2p.base.util;

import cn.wolfcode.p2p.base.domain.Logininfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 123 on 2018/1/18.
 */
public class UserContext {

    private static final String USER_IN_SESSION="logininfo";
    private static final String VERIFYCODE_IN_SESSION="verifyCode";
    private static String ip;

    private static HttpServletRequest getRequest(){
       /* HttpServletRequest request = MyRequestContextHolder.getHttpRequest();
        System.out.println("UserContext中的"+request);*/
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println(request);
        return request;
    }

    public static void setCurrent(Logininfo logininfo){
        getRequest().getSession().setAttribute(USER_IN_SESSION,logininfo);
    }

    public static Logininfo getCurrent(){
       return (Logininfo) getRequest().getSession().getAttribute(USER_IN_SESSION);
    }

    public static String getIp() {
        return getRequest().getRemoteAddr();
    }

    /*public static void setVerifyCode(VerifyCode verifyCode) {
        getRequest().getSession().setAttribute(VERIFYCODE_IN_SESSION,verifyCode);
    }

    public static VerifyCode getVerfyCode(){
        return (VerifyCode) getRequest().getSession().getAttribute(VERIFYCODE_IN_SESSION);
    }*/
}
