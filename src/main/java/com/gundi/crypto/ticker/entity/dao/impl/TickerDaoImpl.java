package com.gundi.crypto.ticker.entity.dao.impl;

import com.gundi.common.entity.dao.impl.ActionDaoBaseImpl;
import com.gundi.crypto.ticker.entity.Ticker;
import com.gundi.crypto.ticker.entity.dao.TickerDao;

import javax.persistence.EntityManager;

/**
 * Created by pai on 27.03.18.
 */
public class TickerDaoImpl extends ActionDaoBaseImpl<Ticker> implements TickerDao{

    public TickerDaoImpl(EntityManager entityManager) {

        super(entityManager, Ticker.class, true);
    }

    public TickerDaoImpl(EntityManager entityManager, boolean autoFlush) {

        super(entityManager, Ticker.class, autoFlush);
    }
}
