package com.mamun.apigateway.filter;



import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class AnalyticsLoggingFilter implements GlobalFilter, Ordered {

    private final WebClient webClient = WebClient.create("http://localhost:8085");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();

        return chain.filter(exchange)
                .then(
                        webClient.post()
                                .uri("/api/v1/analytics/log")
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(Map.of(
                                        "apiId", 1,
                                        "userId", 1,
                                        "apiKey", "demo-key",
                                        "endpoint", path
                                ))
                                .retrieve()
                                .bodyToMono(Void.class)
                                .onErrorResume(e -> Mono.empty())
                );
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
