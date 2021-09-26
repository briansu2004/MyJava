package com.sutek.stockclient;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.IOException;

@Log4j2
public class WebClientStockClient {
	private WebClient webClient;

	public WebClientStockClient(WebClient webClient) {
		this.webClient = webClient;
	}

	public Flux<StockPrice> priceFor(String symbol) {
		//return Flux.fromArray(new StockPrice[0]);
		return webClient.get().uri("localhost:8080/stocks/{symbol}", symbol).retrieve().bodyToFlux(StockPrice.class).retry(5)
			.doOnError(IOException.class, e -> log.error(e.getMessage()));
	}
}
