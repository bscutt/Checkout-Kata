package Products;

/**
 * Created by work on 07/01/15.
 */
public interface Product {
    public String getSku();
    public int getUnitPrice();
    public int getPriceForQuantity(int quantity);
}
