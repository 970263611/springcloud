package com.cloud.demo.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author dingwq
 * @Date 2020/8/25 10:38
 * @Description
 */
@Configuration
public class RouteBean {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        /**
         * 有的时候会持续调到一个节点，因为没刷新配置中心的节点
         * 注意：filter不支持传递特殊字符（例如：_ > < 等）
         */
        return builder.routes()
                .route("gateway_filter_1", r -> r
                        .path("/filter/**")
                        .filters(f -> f.addRequestParameter("gateway-param", "gateway-filter-1:yes-i-got-it!"))
                        .uri("lb://mvc"))
                .route("gateway_filter_2", r -> r
                        .path("/hystrix/**")
                        .filters(f -> f.hystrix(c -> c.setName("my-hystrix").setFallbackUri("forward:/hystrix/fail"))
                                .addRequestParameter("gateway-param", "gateway-filter-2:yes-i-got-it!"))
                        .uri("lb://mvc"))
                .build();
    }
}
