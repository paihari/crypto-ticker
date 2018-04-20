package com.gundi.crypto.ticker;


import com.gundi.crypto.ticker.builder.TickerBuilder;
import com.gundi.crypto.ticker.entity.Ticker;
import com.gundi.crypto.ticker.manager.TickerManager;
import com.variacode.coinmarketcap.CoinMarketCap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by pai on 27.03.18.
 */
public class TickerCaptureJob implements org.quartz.Job {

    private Logger logger = LogManager.getLogger(this.getClass());

    public TickerCaptureJob() {
    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException {

        CoinMarketCap instance = new CoinMarketCap();


        Integer limit = null;
        CoinMarketCap.CurrencyConvert convert = null;
        TickerManager tickerManager = new TickerManager();
        try {
            logger.info("New Ticker Inserted in this Job run");

            List<CoinMarketCap.Ticker> result = instance.getTicker();
            result.forEach(ticker -> logger.info(ticker));

            result.forEach(ticker -> tickerManager.createTicker(new TickerBuilder().name(ticker.getName()).symbol(ticker.getSymbol()).rank(ticker.getRank()).priceUsd(ticker.getPriceUsd()).
                    priceBtc(ticker.getPriceBtc())._24hVolumeUsd(ticker.get24hVolumeUsd()).marketCapUsd(ticker.getMarketCapUsd()).
                    percentChange1h(ticker.getPercentChange1h()).percentChange24h(ticker.getPercentChange24h()).percentChange7d(ticker.getPercentChange7d()).
                    lastUpdated(ticker.getLastUpdated())));
        } catch (CoinMarketCap.CoinMarketCapException e) {
            e.printStackTrace();
        }

        // Show all the tickers in the database
        tickerManager.showTickers();



    }
}
