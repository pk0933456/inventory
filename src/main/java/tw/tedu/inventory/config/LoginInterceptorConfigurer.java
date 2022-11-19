package tw.tedu.inventory.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tw.tedu.inventory.interceptor.LoginInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * 登錄攔截器的配置類
 * 已轉移至SpringSecurity處理
 */
//@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //創建攔截器對象
//        HandlerInterceptor interceptors = new LoginInterceptor();
//        //創建白名單
//        List<String> excludePath = new ArrayList<>();
//        //資源
//        excludePath.add("/build/**");
//        excludePath.add("/dist/**");
//        excludePath.add("/docs/**");
//        excludePath.add("/pages/**");
//        excludePath.add("/plugin/**");
//        //網頁、請求
//        excludePath.add("/register.html");
//        excludePath.add("/users/reg");
//        excludePath.add("/users/login");
//        excludePath.add("/login.html");
//
//        //註冊攔截器
//        registry.addInterceptor(interceptors)
//                .addPathPatterns("/**")        //黑名單
//                .excludePathPatterns(excludePath);   //白名單
//    }
}
