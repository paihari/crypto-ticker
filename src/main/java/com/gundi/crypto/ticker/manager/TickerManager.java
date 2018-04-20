package com.gundi.crypto.ticker.manager;

import com.gundi.crypto.ticker.builder.TickerBuilder;
import com.gundi.crypto.ticker.entity.Ticker;
import com.gundi.crypto.ticker.entity.dao.TickerDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by pai on 27.03.18.
 */
public class TickerManager {

    private EntityManager entityManager;

    private Logger logger = LogManager.getLogger(this.getClass());

    public TickerManager() {
        entityManager = Persistence.createEntityManagerFactory(
                "ticker").createEntityManager();
    }



    public Ticker createTicker(TickerBuilder tickerBuilder) {

        try {

            Ticker t= getTickerDao().create(tickerBuilder.build());

            entityManager.flush();
            entityManager.getTransaction().commit();

            return t;
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Error creating entity ", e);
            throw new IllegalStateException("com.gundi.crypto.ticker.manager.TickerManager.createTicker");
        }

    }

    public void showTickers() {

        logger.info("All Tickers in database");
        List<Ticker> todoList = getTickerDao().findAll();
        todoList.forEach(ticker -> logger.info(ticker));
    }

    protected TickerDao getTickerDao() {
        entityManager.getTransaction().begin();
        return  TickerDao.Factory.getDao(entityManager, true);
    }


}
