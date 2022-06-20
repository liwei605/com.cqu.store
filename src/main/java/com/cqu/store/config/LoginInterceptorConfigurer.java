package com.cqu.store.config;


import com.cqu.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@Configuration  //���ص�ǰ��������������ע��
//��������������ע��
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    //�������������������������
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //����һ���������Ķ��󣬿�������ض���
        HandlerInterceptor interceptor = new LoginInterceptor();
        //���ð������������һ��List������
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/js/**");
        patterns.add("/images/**");
        patterns.add("/index.html");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");patterns.add("products/**");
        //�����������ע��
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns);//Ҫ���ص�URL��ʲô
    }
}
