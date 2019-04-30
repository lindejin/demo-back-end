package com.ldj.demo.interceptor;

import com.ldj.demo.domain.UserInfo;
import com.ldj.demo.util.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ldj
 * @date 2019/4/26 10:46
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        UserInfo login = JwtUtils.unsign(token, UserInfo.class);
        try {
            if (login == null) {
                System.out.println("用户未登录，验证失败");
            } else {

                System.out.println("用户" + login.getUserName() + "已是登录状态");
                return true;
            }

            System.out.println("token解析错误，验证失败");
            response.getWriter().write("请登录再进行操作，谢谢合作。");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.setStatus(403);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
