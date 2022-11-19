package tw.tedu.inventory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import tw.tedu.inventory.handle.MyAccessDeniedHandler;
import tw.tedu.inventory.interceptor.LoginInterceptor;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private MyAccessDeniedHandler myAccessDeniedHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {


		//表單提交
		http.formLogin()
			// 自定義登入頁面
			.loginPage("/login.html")
			// loginpage.html 表單 action 內容
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/home.html")
			.permitAll();
			// 登入成功之後要造訪的頁面
//			.usernameParameter("username")
//			.passwordParameter("password");
//			.successForwardUrl("/home.html")  // welcome 頁面;
			// 登入失敗後要造訪的頁面
//			.failureForwardUrl("/fail.html");

		// 授權認證
		http.authorizeRequests()
			// 不需要被認證的頁面：/loginpage
			.antMatchers("/login.html","/users/login","/login","/users/userLogin","/oauth/authorize",
							"/dist/**","/build/**","/docs/**","/pages/**","/plugins/**").permitAll()
			// 權限判斷
			// 必須要有 1 權限才可以訪問
			.antMatchers("/userpage.html").hasAuthority("1")
			// 其他指定任意角色都可以訪問
//			.antMatchers("/employeepage").hasAnyRole("1", "0")
			// 其他的都要被認證
			.anyRequest().authenticated()
			.and().csrf().disable();

		//csrf防護
//		 http.csrf().disable();
		
		// 登出功能
		http.logout()
			.deleteCookies("JSESSIONID")
			.logoutSuccessUrl("/login.html")
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	
		// 異常處理
		http.exceptionHandling()
			.accessDeniedPage("/403.html");
//			.accessDeniedHandler(myAccessDeniedHandler);
		
		// 記住我功能（remember-me）
//		http.rememberMe()
//			.userDetailsService(userDetailsService)
//			.tokenValiditySeconds(60*60*24*7); //
		
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
