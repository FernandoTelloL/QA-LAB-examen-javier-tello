package com.nttdata.page;

import org.openqa.selenium.By;

public class StoreProductDetailPage {
    public static By increaseQuantityButton = By.cssSelector("button.btn-touchspin.js-touchspin.bootstrap-touchspin-up");
    public static By quantityInput = By.cssSelector("input#quantity_wanted");
    public static By addToCartButton = By.cssSelector("div.add button.btn.btn-primary.add-to-cart[data-button-action='add-to-cart']");
}

