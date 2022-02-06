package com.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;import java.util.Arrays;@Configuration
public class CorsConfig { @Bean
public CorsWebFilter corsWebFilter(){
CorsConfiguration corsConfiguration = new CorsConfiguration();
corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
corsConfiguration.setAllowedMethods(Arrays.asList("GET" ,"POST", "DELETE"));
corsConfiguration.setAllowedHeaders(Arrays.asList("Content-Type", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Authorization", "X-Requested-With", "requestId", "Correlation-Id"));
corsConfiguration.setExposedHeaders(Arrays.asList("token", "loggedInUserRole","loggedInUserName"));
UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
source.registerCorsConfiguration("/**", corsConfiguration);
return new CorsWebFilter(source);
}
}


