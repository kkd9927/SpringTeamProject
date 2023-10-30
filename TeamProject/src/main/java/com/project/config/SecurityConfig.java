package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.security.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final CustomUserDetailsService customUserDetailsService;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
            .authorizeRequests(requests -> requests
            	.antMatchers("/resources/css/*", "/resources/js/*", "/resources/img/*").permitAll()
                .antMatchers("/", "/register", "/register/form").permitAll()
                .antMatchers("/rest/restRegister", "/rest/restList", "/rest/restGet").permitAll()
                .anyRequest().authenticated()
                .and())
            .formLogin(login -> login
                .loginPage("/login")
                .usernameParameter("u_id")
                .passwordParameter("u_pw")
                .defaultSuccessUrl("/")
                .failureUrl("/login/fail")
                .permitAll())
            .logout(logout -> logout
        		.logoutUrl("/logout")
        		.logoutSuccessUrl("/"));
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder());
	}
	
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
