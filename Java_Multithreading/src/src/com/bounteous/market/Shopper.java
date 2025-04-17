package com.bounteous.market;

public class Shopper implements Runnable{
    private final Market market;
    private final String name;
    private final Fruit desiredFruit;

    public Shopper(Market market, String name, Fruit desiredFruit) {
        this.market = market;
        this.name = name;
        this.desiredFruit = desiredFruit;
    }

    @Override
    public void run() {
        try {
            while (true) {
                market.takeFruit(desiredFruit, name);
                Thread.sleep(800);
        }
        } catch (InterruptedException e) {
            System.out.println("[" + name + "] stopped shopping.");
            Thread.currentThread().interrupt();
        }
    }
}
