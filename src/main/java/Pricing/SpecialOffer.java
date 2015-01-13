package Pricing;

import Products.Product;

/**
 * Created by work on 07/01/15.
 */
public interface SpecialOffer {
    public boolean quantityQualifies(int quantity);
    public int getSpecialTotal(int quantity, Product product);
}
