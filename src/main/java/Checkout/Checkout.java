package Checkout;

/**
 * Created by work on 07/01/15.
 */
public interface Checkout {

    public void scan(String sku);
    public int getTotal();

}
