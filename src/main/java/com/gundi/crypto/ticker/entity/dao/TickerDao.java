package com.gundi.crypto.ticker.entity.dao;

import com.gundi.common.entity.dao.ActionDao;
import com.gundi.crypto.ticker.entity.Ticker;
import com.gundi.crypto.ticker.entity.dao.impl.TickerDaoImpl;

import javax.persistence.EntityManager;

/**
 * Created by pai on 27.03.18.
 */
public interface TickerDao extends ActionDao<Ticker>{

    public static class Factory {
        public static TickerDao getDao(EntityManager entityManager) {
            return new TickerDaoImpl(entityManager);
        }

        public static TickerDao getDao(EntityManager entityManager, boolean autoFlush) {
            return new TickerDaoImpl(entityManager, autoFlush);
        }

    }
}
