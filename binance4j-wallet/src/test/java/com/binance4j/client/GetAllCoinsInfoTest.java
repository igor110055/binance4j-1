package com.binance4j.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.service.TestService;
import com.binance4j.wallet.client.WalletClient;
import com.binance4j.wallet.coinsinfo.CoinInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetAllCoinsInfoTest {
	final WalletClient client = TestService.CLIENT;

	@Test
	@DisplayName("It should return the coins info")
	void testGetAllCoinsInfo() throws ApiException {
		List<CoinInformation> infos = client.getAllCoinsInfo().execute();

		infos.forEach(i -> {
			if (i.getCoin().equals("BNB")) {
				System.out.println(i.getNetworkList());
			}
			assertNotNull(i.getCoin());
			assertNotNull(i.getDepositAllEnable());
			assertNotNull(i.getFree());
			assertNotNull(i.getFreeze());
			assertNotNull(i.getIpoable());
			assertNotNull(i.getIpoing());
			assertNotNull(i.getIsLegalMoney());
			assertNotNull(i.getLocked());
			assertNotNull(i.getName());
			assertNotNull(i.getNetworkList());
			assertNotNull(i.getStorage());
			assertNotNull(i.getTrading());
			assertNotNull(i.getWithdrawAllEnable());
			assertNotNull(i.getWithdrawing());
		});
	}
}
