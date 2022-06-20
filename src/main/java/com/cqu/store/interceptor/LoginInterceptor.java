package com.cqu.store.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����һ��������
public class LoginInterceptor implements HandlerInterceptor {
    //�������д�������ķ���֮ǰ���Զ�����ִ�еķ���
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //HttpServletRequest request��ȡsession����
        Object obj = request.getSession().getAttribute("uid");

        if (obj == null) {
            //���û��session��������أ��ض���login.html��¼ҳ��
            response.sendRedirect("/web/login.html");
            //���������ĵ���
            return false;
        }

        //�������
        return true;
    }
}
