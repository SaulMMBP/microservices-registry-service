package io.github.saulmmbp.registryService.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class RegistryServiceConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
		.httpBasic(Customizer.withDefaults());
	
	http.csrf(csrf -> csrf.ignoringRequestMatchers("/eureka/**"));
	
	return http.build();
    }
}
