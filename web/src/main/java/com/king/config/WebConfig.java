package com.king.config;

import com.king.interceptor.TestInterceptor;
import com.king.listener.TestListener;
import com.king.filter.TestFilter;
import com.king.servlet.TestServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author wangchangyong
 * @create 2018/05/23 10:11
 */
//@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TestInterceptor testInterceptor;

    /**
     * servlet
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new TestServlet(),"/servletTest");
    }

    /**
     * filter
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TestFilter());
        registration.addUrlPatterns("/*");
        registration.setName("testFilter");
        return registration;
    }

    /**
     * listener
     */
    @Bean
    public ServletListenerRegistrationBean<TestListener> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<TestListener>(new TestListener());
    }

    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor).addPathPatterns();
    }
}
