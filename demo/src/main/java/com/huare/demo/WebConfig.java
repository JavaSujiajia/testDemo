package com.huare.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器定义
 *
 * @author Minbo.He
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    // 让bean提前加载，让拦截器中的@Autowired生效
    @Bean
    public HandlerInterceptor getMyInterceptor() {
        return new MyHttpInterceptor();
    }

    /**
     * 可定义多个拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 定义过滤拦截的url名称，拦截所有请求
        //http://localhost:8083/swagger-ui.html
        registry.addInterceptor(this.getMyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "swagger-ui.html",
                        "/webjars/**", "/v2/**", "/swagger-ui.html/**");
        //registry.addInterceptor(this.getMyInterceptor()).addPathPatterns("/**");
//		registry.addInterceptor(其他拦截器).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将templates目录下的CSS、JS文件映射为静态资源，防止Spring把这些资源识别成thymeleaf模版
        //  registry.addResourceHandler("/templates/**.js").addResourceLocations("classpath:/templates/");
        //registry.addResourceHandler("/templates/**.css").addResourceLocations("classpath:/templates/");
        //其他静态资源
        //registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //swagger增加url映射
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
