package com.binance4j.spot.client;

import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.spot.order.NewOrder;
import com.binance4j.spot.service.TestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TestNewOrderTest extends ConcurrentTest {
	final SpotClient client = TestService.CLIENT;

	@Test
	@DisplayName("Test must not throw an exception")
	void testNewOrderTest() {
		NewOrder order = NewOrder.buyMarket("SHIBBUSD", new BigDecimal(1000000));
		assertDoesNotThrow(() -> {
			client.newOrderTest(order).execute();
		});
	}
}
