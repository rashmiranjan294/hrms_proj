package com.onpassive.hrms.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	/*
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
	
	
	  @Override
	  protected void configure(HttpSecurity security) throws Exception{
	  security.httpBasic().disable();
	  security.csrf().disable();
	   }
	 
	/*
	 * @Override public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.inMemoryAuthentication().withUser("info@gofounders.net")
	 * .password("Go_ASH&&JUN").roles("USER"); }
	 * 
	 * @Override public void configure(HttpSecurity http) throws Exception {
	 * http.antMatcher("/**").authorizeRequests().anyRequest().hasRole("USER")
	 * .and().formLogin().loginPage("/login.jsp")
	 * .failureUrl("/login.jsp?error=1").loginProcessingUrl("/login")
	 * .permitAll().and().logout() .logoutSuccessUrl("/listEmployees.html");
	 * 
	 * }
	 */
}
