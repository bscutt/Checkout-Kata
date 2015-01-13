package Products;

import Pricing.SpecialOffer;

/**
 * Created by work on 07/01/15.
 */
public class KataProduct implements Product {

    private String sku;
    private int unitPrice;
    private SpecialOffer specialOffer;

    public KataProduct(String sku, int unitPrice) {
        this.sku = sku;
        this.unitPrice = unitPrice;
        this.specialOffer = null;
    }

    public KataProduct(String sku, int unitPrice, SpecialOffer specialOffer) {
        this.sku = sku;
        this.unitPrice = unitPrice;
        this.specialOffer = specialOffer;
    }

    @Override
    public String getSku() {
        return this.sku;
    }

    @Override
    public int getUnitPrice() {
        return this.unitPrice;
    }

    @Override
    public int getPriceForQuantity(int quantity) {

        if (specialOffer != null && specialOffer.quantityQualifies(quantity)) {
            return specialOffer.getSpecialTotal(quantity, this);
        }

        return this.unitPrice * quantity;
    }
}
