package Pricing;

import Products.Product;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by work on 07/01/15.
 */
public class KataPricingStrategy implements PricingStrategy {

    private List<Product> products;

    public KataPricingStrategy(List<Product> products) {
        this.products = products;
    }

    private int getQuantityOfProductInItems(List<String> items, Product product)
    {
        return items.stream()
                .filter(item -> product.getSku().equals(item))
                .collect(Collectors.toList())
                .size();
    }

    @Override
    public int calculateTotalCost(List<String> items) {
        int totalCost = 0;

        for (Product product : products) {
            totalCost += product.getPriceForQuantity(this.getQuantityOfProductInItems(items, product));
        }

        return totalCost;
    }
}
