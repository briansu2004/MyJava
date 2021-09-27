package com.sutek.stockclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.rsocket.RSocketRequester;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class RSocketStockClientIntegrationTest {
	//private WebClient webClient = WebClient.builder().build();

	@Autowired
	private RSocketRequester.Builder builder;

	//localhost doesn't work???
	private RSocketRequester createRSocketRequester() {
		return builder.connectTcp("127.0.0.1", 7000).block();
	}

	@Test
	void shouldRetrieveStockPricesFromTheService() {
		// given
		RSocketStockClient rSocketStockClient = new RSocketStockClient(createRSocketRequester());

		// when
		Flux<StockPrice> prices = rSocketStockClient.priceFor("SYMBOL");

		// then
		Assertions.assertNotNull(prices);
		Flux<StockPrice> fivePrices = prices.take(5);
		//Assertions.assertTrue(fivePrices.count().block() > 0);
		Assertions.assertEquals(5, fivePrices.count().block());
		Assertions.assertEquals("SYMBOL", fivePrices.blockFirst().getSymbol());

		StepVerifier.create(prices.take(5))
			.expectNextMatches(stockPrice -> stockPrice.getSymbol().equals("SYMBOL"))
			.expectNextMatches(stockPrice -> stockPrice.getSymbol().equals("SYMBOL"))
			.expectNextMatches(stockPrice -> stockPrice.getSymbol().equals("SYMBOL"))
			.expectNextMatches(stockPrice -> stockPrice.getSymbol().equals("SYMBOL"))
			.expectNextMatches(stockPrice -> stockPrice.getSymbol().equals("SYMBOL"))
			.verifyComplete();
	}

}