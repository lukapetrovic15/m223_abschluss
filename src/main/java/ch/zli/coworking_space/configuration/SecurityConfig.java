package ch.zli.coworking_space.configuration;

import ch.zli.coworking_space.repository.MemberRepository;
import ch.zli.coworking_space.security.JwtAuthenticationEntryPoint;
import ch.zli.coworking_space.security.JwtAuthenticationFilter;
import ch.zli.coworking_space.security.JwtServiceHMAC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtServiceHMAC jwtService;
    private final MemberRepository memberRepository;

    public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtServiceHMAC jwtService, MemberRepository memberRepository) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtService = jwtService;
        this.memberRepository = memberRepository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**", "/h2-console/**", "/console/**").permitAll().antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtService, memberRepository), UsernamePasswordAuthenticationFilter.class)
                .headers().frameOptions().disable()
                .and()
                .build();
    }

}
