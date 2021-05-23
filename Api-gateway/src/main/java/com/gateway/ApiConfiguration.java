
package com.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {
	/*
	 * isme hm 1 url ko dusre route pe divert kar rahe hai aur kuch add kar rahe hai
	 */

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes().route(p -> p.path("/get")
				.filters(f -> f.addRequestHeader("headerName", "My Header").addRequestParameter("param", "MyParam"))
				.uri("http://httpbin.org:80")).route(p -> p.path("/getUser/**").uri("lb://user"))
				.route(p -> p.path("/getStudent/**").uri("lb://student")).

				route(p -> p.path("/getUser/feign/**").uri("lb://user")).

				route(p -> p.path("/getUser-new/**")
						.filters(f -> f.rewritePath("/getUser-new/(?<segment>.*)", "/getUser/feign/${segment}"))
						.uri("lb://user"))
				.build();

	}

}
