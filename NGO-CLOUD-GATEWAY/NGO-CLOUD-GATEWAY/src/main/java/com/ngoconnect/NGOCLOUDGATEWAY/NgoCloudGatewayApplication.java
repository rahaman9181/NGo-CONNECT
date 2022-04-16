package com.ngoconnect.NGOCLOUDGATEWAY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class NgoCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgoCloudGatewayApplication.class, args);
		
	}
	@Configuration
	 class CorsConfiguration{
	    @Bean
	    public CorsWebFilter corsWebFilter() {

	        org.springframework.web.cors.CorsConfiguration corsConfig = new org.springframework.web.cors.CorsConfiguration();
	        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
	        corsConfig.setMaxAge(3600L);
	        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST","PUT"));
	        corsConfig.addAllowedHeader("*");

	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", corsConfig);

	        return new CorsWebFilter(source);
	    }
	}
	/*
	@Autowired
	RouteDefinitionLocator locator;

	@Bean
	public List<GroupedOpenApi> apis() {
		List<GroupedOpenApi> groups = new ArrayList<>();
		List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
		System.err.println(definitions);
		assert definitions != null;
		definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-SERVICE")).forEach(routeDefinition -> {
			String name = routeDefinition.getId().replaceAll("-SERVICE", "");
			groups.add(GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build());
		});
		return groups;
	}
	*/
}
