package com.cts.zs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.google.common.collect.ImmutableList;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
   	 http.cors();
       http.csrf().
       disable();

   }

@Bean
public CorsConfigurationSource corsConfigurationSource() {
   final CorsConfiguration configuration = new CorsConfiguration();
   configuration.setAllowedOrigins(ImmutableList.of("*"));
   configuration.setAllowedMethods(ImmutableList.of("HEAD",
           "GET", "POST", "PUT", "DELETE", "PATCH"));
   // setAllowCredentials(true) is important, otherwise:
   // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
   configuration.setAllowCredentials(true);
   // setAllowedHeaders is important! Without it, OPTIONS preflight request
   // will fail with 403 Invalid CORS request
   configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
   final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
   source.registerCorsConfiguration("/**", configuration);
   return source;
}

}
