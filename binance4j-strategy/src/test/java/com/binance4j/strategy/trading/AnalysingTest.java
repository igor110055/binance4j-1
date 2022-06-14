package com.binance4j.strategy.trading;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.strategy.backtesting.BackTestResult;
import com.binance4j.strategy.strategies.TwoPeriodRSIStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ta4j.core.Position;

class AnalysingTest {

    @Test
    @DisplayName("Analyse and backtest positions should be the same")
    void testBacktestWithInputBars() throws IOException, ApiException {
        TwoPeriodRSIStrategy strategy = new TwoPeriodRSIStrategy();
        BackTestResult result = strategy.backTest("BTCBUSD", CandlestickInterval.FIVE_MINUTES, "2022", "01");
        List<Position> positions = result.getTradingRecord().getPositions();

        positions.forEach(p -> {
            assertTrue(strategy.shouldEnter(result.getSeries(), p.getEntry().getIndex()));
            assertTrue(strategy.shouldExit(result.getSeries(), p.getExit().getIndex()));
        });
    }

}
