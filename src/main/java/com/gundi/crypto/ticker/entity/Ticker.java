package com.gundi.crypto.ticker.entity;

import com.gundi.common.entity.impl.AuditableEntityBase;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Created by pai on 27.03.18.
 */

@Entity
@NamedQueries({
        @NamedQuery(name="Ticker.findAll", query="select t from Ticker t")
})
public class Ticker  extends AuditableEntityBase implements Serializable {

    private Long id;



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


    public Ticker() {

    }

    public Ticker(String name, String symbol, Integer rank,
                  BigDecimal priceUsd, BigDecimal priceBtc, BigDecimal _24hVolumeUsd,
                  BigDecimal marketCapUsd, BigDecimal percentChange1h,
                  BigDecimal percentChange24h, BigDecimal percentChange7d,
                  Date lastUpdated) {
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.priceUsd = priceUsd;
        this.priceBtc = priceBtc;
        this._24hVolumeUsd = _24hVolumeUsd;
        this.marketCapUsd = marketCapUsd;
        this.percentChange1h = percentChange1h;
        this.percentChange24h = percentChange24h;
        this.percentChange7d = percentChange7d;
        this.lastUpdated = lastUpdated;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public BigDecimal getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(BigDecimal priceUsd) {
        this.priceUsd = priceUsd;
    }

    public BigDecimal getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(BigDecimal priceBtc) {
        this.priceBtc = priceBtc;
    }

    @Column(name="volumeUsd24")
    public BigDecimal get_24hVolumeUsd() {
        return _24hVolumeUsd;
    }

    public void set_24hVolumeUsd(BigDecimal _24hVolumeUsd) {
        this._24hVolumeUsd = _24hVolumeUsd;
    }

    public BigDecimal getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(BigDecimal marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public BigDecimal getPercentChange1h() {
        return percentChange1h;
    }

    public void setPercentChange1h(BigDecimal percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    public BigDecimal getPercentChange24h() {
        return percentChange24h;
    }

    public void setPercentChange24h(BigDecimal percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    public BigDecimal getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(BigDecimal percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", rank=" + rank +
                ", priceUsd=" + priceUsd +
                ", priceBtc=" + priceBtc +
                ", _24hVolumeUsd=" + _24hVolumeUsd +
                ", marketCapUsd=" + marketCapUsd +
                ", percentChange1h=" + percentChange1h +
                ", percentChange24h=" + percentChange24h +
                ", percentChange7d=" + percentChange7d +
                ", lastUpdated=" + lastUpdated +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ticker ticker = (Ticker) o;
        return Objects.equals(id, ticker.id) &&
                Objects.equals(name, ticker.name) &&
                Objects.equals(symbol, ticker.symbol) &&
                Objects.equals(rank, ticker.rank) &&
                Objects.equals(priceUsd, ticker.priceUsd) &&
                Objects.equals(priceBtc, ticker.priceBtc) &&
                Objects.equals(_24hVolumeUsd, ticker._24hVolumeUsd) &&
                Objects.equals(marketCapUsd, ticker.marketCapUsd) &&
                Objects.equals(percentChange1h, ticker.percentChange1h) &&
                Objects.equals(percentChange24h, ticker.percentChange24h) &&
                Objects.equals(percentChange7d, ticker.percentChange7d) &&
                Objects.equals(lastUpdated, ticker.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, symbol, rank, priceUsd, priceBtc, _24hVolumeUsd, marketCapUsd, percentChange1h, percentChange24h, percentChange7d, lastUpdated);
    }
}
