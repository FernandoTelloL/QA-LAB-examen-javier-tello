package com.nttdata.page;

import org.openqa.selenium.By;

public class StoreCartPage {
    public static By cartTitle = By.cssSelector("h1.h1");
    public static By productUnitPrice = By.cssSelector(".current-price span.price");
    public static By productQuantity = By.cssSelector("input.js-cart-line-product-quantity");
    public static By cartTotalInclTax = By.cssSelector(".cart-summary-line.cart-total span.value");
}

