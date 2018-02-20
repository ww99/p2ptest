package cn.wolfcode.p2p.website.interceptor;

import cn.wolfcode.p2p.base.util.UserContext;
import cn.wolfcode.p2p.website.util.RequireLogin;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 123 on 2018/2/19.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    /**
     * 登陆拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod hm = (HandlerMethod) handler;
        RequireLogin anno = hm.getMethodAnnotation(RequireLogin.class);
        if (anno != null){
            if (UserContext.getCurrent() == null){
                response.sendRedirect("/login.html");
                return false;
            }
        }
        return true;
    }
}
