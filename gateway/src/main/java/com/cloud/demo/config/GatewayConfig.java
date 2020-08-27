package com.cloud.demo.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @Author dingwq
 * @Date 2020/8/25 11:37
 * @Description
 */
@Configuration
public class GatewayConfig {

    @Bean
    @Order(-1)
    public GlobalFilter globalFilter() {
        return (exchange, chain) -> {
//            ServerHttpRequest request = exchange.getRequest();
//            HttpHeaders headers = request.getHeaders();
//            String ipAddress = IPUtil.getIpAddress(headers, request);
//            System.out.println("当前访问IP ：[" + ipAddress + "]");
//            MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
//            String gatewayParam = queryParams.getFirst("gateway-param");
//            System.out.println("GlobalFilter -> gatewayParam ->" + gatewayParam);
            return chain.filter(exchange);
        };
    }
}
