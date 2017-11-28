package com.lanou.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by dllo on 17/11/10.
 */
public class LoginInterceptor implements HandlerInterceptor {

    //在HandlerMapping寻找控制器之前会进入的方法,即业务处理完毕单视图还没返回进入的方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // 除了登录请求之外的其他任何请求都进入登录判断
        // 如果在HttpSession没有储存过的登录信息,则认为没有登录过,则需要跳转到登录界面
        // 如果在HttpSession中储存过登录信息,则认为已经登录,可以放行
        String url = request.getRequestURI();// 获取请求路径
        if (url.indexOf("login") != -1) {
            return true;// 放行
        }
        // 获取session对象
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null || username.equals(url)) {
            // 如果没有登录过需要转发到登录页面
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
        }
        return true;
    }

    //控制器结束之后会进入的方法
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    // 当整个孔子器方法完成之后,即视图和数据都处理完毕之后会进入的方法
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
