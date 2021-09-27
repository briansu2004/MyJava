package com.sutek.stockclient;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfiguration {
	@Bean
	@Profile("sse")
	public WebClientStockClient webClientStockClient(WebClient webClient) {
		return new WebClientStockClient(webClient);
	}

	@Bean
	@Profile("rsocket")
	public StockClient rSocketStockClient(RSocketRequester rSocketStockClient) {
		return new RSocketStockClient(rSocketStockClient);
	}

	@Bean
	public RSocketRequester rSocketRequester(RSocketRequester.Builder builder) {
		return builder.connectTcp("127.0.0.1", 7000).block();
	}

	@Bean
	@ConditionalOnMissingBean
	public WebClient webClient() {
		return WebClient.builder().build();
	}
}
