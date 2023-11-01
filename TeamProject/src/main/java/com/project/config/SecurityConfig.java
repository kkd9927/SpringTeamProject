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
	
	// 서버로 들어오는 http 요청에 대한 보안설정
	@Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable()) // CSRF 보안 비활성화
            .authorizeRequests(requests -> requests // 요청 URL에 대한 권한설정
            	.antMatchers("/resources/css/*", "/resources/js/*", "/resources/img/*").permitAll()
                .antMatchers("/", "/register", "/register/form").permitAll()
                .antMatchers("/rest/restRegister", "/rest/restList", "/rest/restGet").permitAll()
                // antMatchers() => 요청 URL 지정
                // permitAll() => 무조건 허용
                // hasRole(), hasAuthority()등 별도의 권한설정을 해주는 메소드가 존재함
                .anyRequest().authenticated() // 이외 모든 요청에대해 인증된 권한이 필요
                .and())
            .formLogin(login -> login // 로그인 페이지를 지정해서 로그인 요청(POST)에 대해 자동으로 파라미터 수집
                .loginPage("/login") // 로그인 URL 설정, 로그인 페이지로 이동하는 GET 요청에 대해서는 컨트롤러에서 처리
                .usernameParameter("u_id") // 로그인 폼에서 아이디에 해당하는 이름을 지정, <input name="u_id">
                .passwordParameter("u_pw") // 로그인 폼에서 비밀번호에 해당하는 이름을 지정, <input name="u_pw">
                .defaultSuccessUrl("/") // 로그인이 성공할 경우 이동할 경로
                .failureUrl("/login/fail") // 로그인이 실패할 경우 이동할 경로
                .permitAll()) // 로그인 페이지에 대한 접근 무조건 허용
            .logout(logout -> logout // 로그아웃 설정, 아래에서 설정하는 URL로 접근 할 경우 자동으로 세션에서 인증객체를 제거함
        		.logoutUrl("/logout") // 로그아웃 URL 설정
        		.logoutSuccessUrl("/")); // 로그아웃이 성공할 경우 이동할 경로
    }

	// 인증객체를 만들어 줄 서비스에 대한 설정
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder());
		// CustomUserDetailsService는 UserDetailsService를 구현함
		// loadUserByUsername() 메소드를 오버라이딩 하여 로그인 요청시 자동으로 메소드 실행
		// passwordEncoder() => DB의 비밀번호가 암호화 되어있을 경우 로그인 요청시 들어오는 비밀번호 또한 암호화 시켜
		// 해시값을 대조해야 하기 때문에 비밀번호 인코더 설정
	}
	
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
        // 비밀번호 암호화 함수를 리턴하는 빈
        // BCrypt 함수는 현재 비밀번호 암호화에서 가장 많이 사용되는 단방향 암호화 해시 함수(복호화 불가)
        // 동일한 문자열에 대해서 무조건 같은 해시값을 생성하는 원리를 이용함
        // 문자열 그대로 암호화해서 저장하면 문자열에 대한 해시함수를 여러개 모아서(레인보우 테이블) 해킹 시도가 가능함
        // 입력받은 문자열에 무작위 문자열(Salt)을 더해 암호화 시키는 솔팅(Salting)을 통해 해킹을 방지함
    }
}
