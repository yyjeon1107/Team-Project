package com.test.join;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;


@Configuration // 스프링의 환경설정 파일임을 의미하는 애너테이션이다. 여기서는 스프링 시큐리티의 설정을 위해 사용
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests().antMatchers("/**").permitAll()
	            .and()
	                .csrf().ignoringAntMatchers("/h2-console/**")
	            .and()
	                .headers()
	                .addHeaderWriter(new XFrameOptionsHeaderWriter(
	                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
	            ;
	    }
	 
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
        
}
