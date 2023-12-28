package com.example.InfoNations.config;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()



                //post request

                .requestMatchers(HttpMethod.POST,"/user/new").permitAll()
                .requestMatchers(HttpMethod.POST,"/nation/new").hasRole("USER")
                .requestMatchers(HttpMethod.POST,"/nation/reple/{id}").hasRole("USER")
                //get request
                .requestMatchers(HttpMethod.GET,"nations/reple/{id}","/nations","/nation/{id}","/user/{id}").hasRole("USER")

                //put request
                .requestMatchers(HttpMethod.PUT,"/nation/{id}","/user/{id}").hasRole("USER")

                //delete request
                .requestMatchers(HttpMethod.DELETE,"/nation/{id}").hasRole("USER")
                .requestMatchers(HttpMethod.DELETE,"/user/{id}").hasRole("USER")

                .and()

                .formLogin()
                .usernameParameter("username") // 계정 ID
                .passwordParameter("password") //비밀번호
                .loginProcessingUrl("/login") //스프링 시큐리티가 제공하는 로그인 인증 기능
                .defaultSuccessUrl("/nations")

        // 로그아웃 처리 URL (= form action url)
        //.logoutSuccessUrl("/login") // 로그아웃 성공 후 targetUrl,
        // logoutSuccessHandler 가 있다면 효과 없으므로 주석처리.
        ;

        return http.build();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

