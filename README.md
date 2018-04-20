# Crypto-Ticker

Simple gradle Java application, fetches the ticker of Top 100 Crypto Coin, stores in the database

# Instructions for setting up

1. `https://github.com/paihari/crypto-ticker.git`
2. `cd crypto-ticker`
3. Edit javax.persistence.jdbc.url property in /crypto-ticker/src/main/resources/META-INF/persistence.xml to point to a convinient folder to store derby data files
4. `./gradlew clean build`
5. `./gradlew run`

The Quartz job will schedule the job to fetch the top 100 tickers every 60 seconds from coinmarketcap API and persist the tickers in the Derby Database.

# Contribution

miguelantonio/coinmarketcap-java


