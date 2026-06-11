package br.com.vasscommerceAdrian.config;

import br.com.vasscommerceAdrian.security.CustomAccessDeniedHandler;
import br.com.vasscommerceAdrian.security.CustomAuthenticationEntryPoint;
import br.com.vasscommerceAdrian.security.JwtAuthFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http , JwtAuthFilter jwtAuthFilter) throws Exception{
        http
                .cors(cors -> {})
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth


                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()


                        .requestMatchers(HttpMethod.GET, "/admin/relatorios").hasRole("ADMIN")


                        .requestMatchers("/administrador/**").hasRole("ADMIN")


                        .requestMatchers(HttpMethod.POST, "/produto/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/produto/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/produto/**").hasRole("ADMIN")


                        .requestMatchers(HttpMethod.POST, "/categoria/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/categoria/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/categoria/**").hasRole("ADMIN")


                        .requestMatchers(HttpMethod.GET, "/produto/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/categoria/**").hasAnyRole("USER", "ADMIN")


                        .requestMatchers("/pedido/**").hasRole("USER")
                        .requestMatchers("/cartao/**").hasRole("USER")
                        .requestMatchers("/cliente/**").hasRole("USER")
                        .requestMatchers("/endereco/**").hasRole("USER")


                        .anyRequest().authenticated()
                )

                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(authenticationEntryPoint)
                        .accessDeniedHandler(accessDeniedHandler)
                )

                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("123456"))
                .roles("ADMIN")
                .build();


        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("123456"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(List.of(authProvider));
    }
}
