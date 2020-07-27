package com.luv2code.springsecurity.demo.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.luv2code.springsecurity.demo.service.UserService;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	//add a reference to our security data source
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	private static final Logger logger = Logger.getLogger(DemoSecurityConfig.class);

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===DemoSecurityConfig.configure(AuthenticationManagerBuilder auth)");
		
		logger.info("===WILL CALL: auth.authenticationProvider(authenticationProvider())" );
		
		auth.authenticationProvider(authenticationProvider());
		
		logger.info("END ******************************************");
		logger.info("\n\n\n");
		logger.info("\n\n\n");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===DemoSecurityConfig.configure(HttpSecurity http)");
		
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/employees").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			.formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.successHandler(customAuthenticationSuccessHandler)
			.permitAll()
			.and()
			.logout()
			.logoutSuccessUrl("/")
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		
		logger.info("END ******************************************");
		logger.info("\n\n\n");
		logger.info("\n\n\n");
	}
	
	
	//bcrypt bean definition
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===DemoSecurityConfig.passwordEncoder()");
		
		BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder();
		
		logger.info("===BCryptPasswordEncoder: " + bEncoder);
		logger.info("END ******************************************");
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		return bEncoder;
	}
	
	//authenticationProvider bean definition
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);//set the custom user details service
		auth.setPasswordEncoder(passwordEncoder());//set the password encoder - bcrypt
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===DemoSecurityConfig.authenticationProvider()");
		
		logger.info("===CALL: DaoAuthenticationProvider auth = new DaoAuthenticationProvider()");
		logger.info("===CALL: auth.setUserDetailsService(userService)");
		logger.info("===CALL: auth.setPasswordEncoder(passwordEncoder())");
		
		logger.info("===DaoAuthenticationProvider: " + auth);
		
		logger.info("END ******************************************");
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		
		return auth;
	}
	
	
	

}
