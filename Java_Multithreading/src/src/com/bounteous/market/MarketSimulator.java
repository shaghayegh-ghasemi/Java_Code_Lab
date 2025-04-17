package com.bounteous.market;

public class MarketSimulator {
    private final int numFarmers;
    private final int numShoppers;

    public MarketSimulator(int numFarmers, int numShoppers) {
        this.numFarmers = numFarmers;
        this.numShoppers = numShoppers;
    }

    public void openMarket() {
        Market market = new Market();

        // Start farmers
        for (int i = 0; i < numFarmers; i++) {
            Thread farmerThread = new Thread(new Farmer(market, "Farmer-" + i));
            farmerThread.start();
        }

        // Start shoppers
        Fruit[] fruitTypes = Fruit.values();
        for (int i = 0; i < numShoppers; i++) {
            Fruit desiredFruit = fruitTypes[i % fruitTypes.length];
            Thread shopperThread = new Thread(new Shopper(market, "Shopper-" + i, desiredFruit));
            shopperThread.start();
        }
    }
}
