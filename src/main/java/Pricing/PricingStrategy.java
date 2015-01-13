package Pricing;

import java.util.List;

/**
 * Created by work on 07/01/15.
 */
public interface PricingStrategy {

    public int calculateTotalCost(List<String> items);

}
