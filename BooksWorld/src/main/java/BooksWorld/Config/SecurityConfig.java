package BooksWorld.Config;

import BooksWorld.Repositories.UserRepository;
import BooksWorld.Services.Impl.BookUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/login","/api/register").permitAll()
                                .anyRequest().authenticated())
                .formLogin().disable()
                .logout(
                        logout-> {
                            logout
                                    // the url where we should post something in order to perform logout
                                    .logoutUrl("/api/logout")
                                    // where to go logged out?
                                    .logoutSuccessUrl("/home")
                                    // invalidate the http session
                                    .invalidateHttpSession(true);
                        }
                );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder,
                                                      BookUserDetailsService bookUserDetailsService ) throws Exception {

        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(bookUserDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
