package com.ssw.shoppingmall.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by wisebirds on 2017-05-31.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 기본로그인 설정 admin/0000
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        //사용자 인증이 된 요청에 대해서만 요청을 허용한다.
        http.authorizeRequests()
                .antMatchers("/login").permitAll()//URL이 “/login”일 경우 사용자는 해당 요청에 접근할 수 있습니다.
                .antMatchers("/**").authenticated().and().csrf().disable();

        http
                .formLogin()
                // 로그인 처리 페이지
                // 이번엔 직접 작성한 뷰를 보여줄 것이기 때문에 사용자에게
                // login 이라는 화면을 보여주는게 더 깔끔할 것 같아서 교체함!
                .loginProcessingUrl("/loginProcessing")
                // 로그인 페이지
                .loginPage("/login")
                //.defaultSuccessUrl("/account/my_account")
                .successHandler(successHandler())
                // 로그인 실패 페이지
                .failureUrl("/login?error");

        http
                .logout()
                // /logout 을 호출할 경우 로그아웃
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // 로그아웃이 성공했을 경우 이동할 페이지
                .logoutSuccessUrl("/login");
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new CustomLoginSuccessHandler("/account/my_account");
    }

}
