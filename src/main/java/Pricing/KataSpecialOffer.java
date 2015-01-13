package Pricing;

import Products.Product;

/**
 * Created by work on 07/01/15.
 */
public class KataSpecialOffer implements SpecialOffer {

    private int quantityForOffer, offerPrice;

    public KataSpecialOffer(int quantityForOffer, int offerPrice) {
        this.quantityForOffer = quantityForOffer;
        this.offerPrice = offerPrice;
    }

    @Override
    public boolean quantityQualifies(int quantity) {
        return quantityForOffer <= quantity;
    }

    @Override
    public int getSpecialTotal(int quantity, Product product) {
        return (offerPrice * (quantity / quantityForOffer)) + (product.getUnitPrice() * (quantity % quantityForOffer));
    }
}
