package com.gundi.crypto.ticker.builder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.gundi.common.base.Builder;
import com.gundi.crypto.ticker.entity.Ticker;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by pai on 28.03.18.
 */
public class TickerBuilder implements Builder<Ticker> {


    private String name;
    private String symbol;
    private Integer rank;
    private BigDecimal priceUsd;
    private BigDecimal priceBtc;
    private BigDecimal _24hVolumeUsd;
    private BigDecimal marketCapUsd;
    private BigDecimal percentChange1h;
    private BigDecimal percentChange24h;
    private BigDecimal percentChange7d;
    private Date lastUpdated;

    public TickerBuilder() {
    }

    public TickerBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public TickerBuilder symbol(final String symbol) {
        this.symbol = symbol;
        return this;
    }

    public TickerBuilder rank(final Integer rank) {
        this.rank = rank;
        return this;
    }

    public TickerBuilder priceUsd(final BigDecimal priceUsd) {
        this.priceUsd = priceUsd;
        return this;
    }

    public TickerBuilder priceBtc(final BigDecimal priceBtc) {
        this.priceBtc = priceBtc;
        return this;
    }

    public TickerBuilder _24hVolumeUsd(final BigDecimal _24hVolumeUsd) {
        this._24hVolumeUsd = _24hVolumeUsd;
        return this;
    }

    public TickerBuilder marketCapUsd(final BigDecimal marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
        return this;
    }

    public TickerBuilder percentChange1h(final BigDecimal percentChange1h) {
        this.percentChange1h = percentChange1h;
        return this;
    }

    public TickerBuilder percentChange24h(final BigDecimal percentChange24h) {
        this.percentChange24h = percentChange24h;
        return this;
    }

    public TickerBuilder percentChange7d(final BigDecimal percentChange7d) {
        this.percentChange7d = percentChange7d;
        return this;
    }

    public TickerBuilder lastUpdated(final Long lastUpdated) {
        this.lastUpdated = new Date(lastUpdated);
        return this;
    }

    @Override
    public Ticker build() {
        return new Ticker(name, symbol, rank,
                priceUsd, priceBtc,  _24hVolumeUsd,
                marketCapUsd, percentChange1h,
                percentChange24h, percentChange7d,
                lastUpdated);
    }
}
