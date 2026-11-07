
package fr.iscod.coworkia.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                // Désactivation CSRF pour autoriser les requêtes PUT, POST et DELETE
                .csrf(csrf -> csrf.disable())

                // Gestion des autorisations
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers(
                                "/workspace",
                                "/workspace/**",
                                "/booking",
                                "/booking/**"
                        )
                        .authenticated()
                        .anyRequest().authenticated()
                )

                // Autorisation de la console H2
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin())
                )

                // Authentification HTTP Basic
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
