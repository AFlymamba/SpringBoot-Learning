package com.springboot.rbac.config;

import com.springboot.rbac.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringMVC 相关配置
 *
 * @author huangyin
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 配置放行规则：走application.yml中的配置
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationInterceptor())
                .addPathPatterns("/user/**");
    }
}
