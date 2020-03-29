package com.mytime.authCenterServer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{
	@Autowired
	@Qualifier("SSOUserDetailsService")
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setHideUserNotFoundExceptions(false);
		return authenticationProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/oauth_login","/webjars/**","/oauth/**","oauth_login.html").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				//指定登录页的路径
				.loginPage("/oauth_login")
				//指定自定义form表单请求的路径
				.loginProcessingUrl("/authentication/form")
				.failureUrl("/login?error")
				//.defaultSuccessUrl("/success")
				//必须允许所有用户访问我们的登录页（例如未验证的用户，否则验证流程就会进入死循环）
				//这个formLogin().permitAll()方法允许所有用户基于表单登录访问/login这个page。
				.permitAll();
		//默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
		http .csrf().disable();
		//http
				//.requestMatchers().antMatchers("/oauth/**", "/login/**", "/logout/**","/auth/login/**","/auth/loginPage")
				//.and()
				//.authorizeRequests()
				//.antMatchers("/oauth/**").authenticated()
				//.and()
				//.formLogin()
				//.loginPage("/loginPage") //自定义登录页面
				//.failureForwardUrl("/loginPage?error")   //自定错误
				//.loginProcessingUrl("/auth/loginProcessUrl")  //提交action  也就是form表单中的action  login会调用security的登录不用自己实现
				//.permitAll()
				//;
		/*http.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.deleteCookies("remember-me")
				.invalidateHttpSession(true);*/
		/*http
				.authorizeRequests(authorize -> authorize
						.anyRequest().authenticated()
				)
				.oauth2Login(withDefaults());*/
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/plugins/**", "/favicon.ico");
	}
}
