package com.soltel.elex.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filtro(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()))
            .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers("/clientes/**", "/reservas/**").permitAll()
                .anyRequest().authenticated())
            .formLogin(form -> form
                .defaultSuccessUrl("/swagger-ui/index.html#/", true));
                
        return http.build();
    }

    @Bean
    PasswordEncoder codificador() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService servicio(PasswordEncoder codificador) {
        UserDetails usuarioAdmin = User.builder()
            .username("soltel")
            .password(codificador.encode("admin"))
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(usuarioAdmin);
    }
}