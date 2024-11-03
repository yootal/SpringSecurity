package security.basic.studysecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/", "/login", "/join", "/joinProc").permitAll() // 모두 접근 허용
                        .requestMatchers("/admin").hasRole("ADMIN") // ROLE_ADMIN 앞은 빼고 확인한다.
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                );

        http
//                .httpBasic(Customizer.withDefaults()); // httpBasic 방식
                .formLogin((auth) -> auth.loginPage("/login") // formLogin 방식
                        .loginProcessingUrl("/loginProc") // 해당 경로로 요청시 로그인 로직 실행
                        .permitAll()
                );

        http
                .csrf(AbstractHttpConfigurer::disable); // CSRF 설정, 앱 API 서버는 필요 X

        http
                .sessionManagement((auth) -> auth
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(true)); // 세션 수 초과 시 새로운 로그인 차단

        http // 세션 고정 공격 방어
                .sessionManagement((auth) -> auth
                        .sessionFixation().changeSessionId() // 로그인 시 동일한 세션에 대한 id 변경
                );

        return http.build();
    }
}