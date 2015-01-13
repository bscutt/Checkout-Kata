package Checkout;

import Pricing.PricingStrategy;

import java.util.LinkedList;

/**
 * Created by work on 07/01/15.
 */
public class KataCheckout implements Checkout {

    private PricingStrategy pricingStrategy;
    private LinkedList<String> items = new LinkedList<>();

    public KataCheckout(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public void scan(String sku) {
        items.add(sku);
    }

    @Override
    public int getTotal() {
        return pricingStrategy.calculateTotalCost(items);
    }
}
