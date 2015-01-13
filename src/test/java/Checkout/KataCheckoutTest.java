package Checkout;

import Pricing.KataPricingStrategy;
import Pricing.KataSpecialOffer;
import Pricing.PricingStrategy;
import Pricing.SpecialOffer;
import Products.KataProduct;
import Products.Product;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by work on 07/01/15.
 */
public class KataCheckoutTest {
    @Test
    public void testCanCreateCheckout() {
        PricingStrategy pricingStrategy = new KataPricingStrategy(new LinkedList<Product>());
        Checkout checkout = new KataCheckout(pricingStrategy);
        assertNotNull("Checkout should not be null", checkout);
    }

    @Test
    public void testScanSkuDGetTotalIs15() {
        Product productD = new KataProduct("D", 15);
        List<Product> products = new LinkedList<>();
        products.add(productD);
        PricingStrategy pricingStrategy = new KataPricingStrategy(products);
        Checkout checkout = new KataCheckout(pricingStrategy);
        checkout.scan("D");
        assertEquals("Sku D should be 15", 15, checkout.getTotal());
    }

    @Test
    public void testScanSkuDTwiceGetTotalIs30() {
        Product productD = new KataProduct("D", 15);
        List<Product> products = new LinkedList<>();
        products.add(productD);
        PricingStrategy pricingStrategy = new KataPricingStrategy(products);
        Checkout checkout = new KataCheckout(pricingStrategy);
        checkout.scan("D");
        checkout.scan("D");
        assertEquals("Total should be 30", 30, checkout.getTotal());
    }

    @Test
    public void testScanSkuDAndCGetTotalIs35() {
        Product productD = new KataProduct("D", 15);
        Product productC = new KataProduct("C", 20);
        List<Product> products = new LinkedList<>();
        products.add(productD);
        products.add(productC);
        PricingStrategy pricingStrategy = new KataPricingStrategy(products);
        Checkout checkout = new KataCheckout(pricingStrategy);
        checkout.scan("D");
        checkout.scan("C");
        assertEquals("Total should be 35", 35, checkout.getTotal());
    }

    @Test
    public void testScanSkuAThreeTimesForSpecialOfferAndGetTotalIs130() {
        SpecialOffer offer = new KataSpecialOffer(3, 130);
        Product productA = new KataProduct("A", 50, offer);
        List<Product> products = new LinkedList<>();
        products.add(productA);
        PricingStrategy pricingStrategy = new KataPricingStrategy(products);
        Checkout checkout = new KataCheckout(pricingStrategy);
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        assertEquals("Total should be 130", 130, checkout.getTotal());
    }

    @Test
    public void testScanSkuAFourTimesAndGetTotalIs180() {
        SpecialOffer offer = new KataSpecialOffer(3, 130);
        Product productA = new KataProduct("A", 50, offer);
        List<Product> products = new LinkedList<>();
        products.add(productA);
        PricingStrategy pricingStrategy = new KataPricingStrategy(products);
        Checkout checkout = new KataCheckout(pricingStrategy);
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        assertEquals("Total should be 180", 180, checkout.getTotal());
    }

    @Test
    public void testScanSkuASixTimesAndGetTotalIs260() {
        SpecialOffer offer = new KataSpecialOffer(3, 130);
        Product productA = new KataProduct("A", 50, offer);
        List<Product> products = new LinkedList<>();
        products.add(productA);
        PricingStrategy pricingStrategy = new KataPricingStrategy(products);
        Checkout checkout = new KataCheckout(pricingStrategy);
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        assertEquals("Total should be 260", 260, checkout.getTotal());
    }

    @Test
    public void testScanSkuAFourTimesAndSkuTwiceGetTotalIs225() {
        SpecialOffer offerA = new KataSpecialOffer(3, 130);
        Product productA = new KataProduct("A", 50, offerA);
        SpecialOffer offerB = new KataSpecialOffer(2, 45);
        Product productB = new KataProduct("B", 30, offerB);

        List<Product> products = new LinkedList<>();
        products.add(productA);
        products.add(productB);

        PricingStrategy pricingStrategy = new KataPricingStrategy(products);
        Checkout checkout = new KataCheckout(pricingStrategy);
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("B");
        checkout.scan("B");
        assertEquals("Total should be 225", 225, checkout.getTotal());
    }
}
