
package com.hzxy.language.web.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //默认拦截所有
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**")
                //排除不拦截的页面
                .excludePathPatterns("/user/login","/static/**","/user/registerForm","/user/register");
    }
}

