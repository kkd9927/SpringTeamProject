package com.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.service.UserLoginService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	UserLoginService userLoginService;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception{
//        http.csrf().disable()
//        	.authorizeRequests()
//        	.antMatchers("/").permitAll()
//        	.anyRequest().authenticated();  

        http.csrf(csrf -> csrf.disable())
            .authorizeRequests(requests -> requests
                .antMatchers("/", "/register", "/login").permitAll()
                .anyRequest().authenticated()
                .and())
            .formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login")
                .usernameParameter("u_id")
                .permitAll());
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}1111").roles("USER");
		auth.inMemoryAuthentication().withUser("business").password("{noop}1111").roles("USER", "BUSINESS");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}1111").roles("ADMIN", "USER", "BUSINESS");
		
		auth.userDetailsService(userLoginService).passwordEncoder(getPasswordEncoder());
	}
	
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
