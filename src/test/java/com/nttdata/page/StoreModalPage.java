package com.nttdata.page;

import org.openqa.selenium.By;

public class StoreModalPage {
    public static By modalCart = By.cssSelector("#blockcart-modal");
    public static By modalTitle = By.cssSelector("#myModalLabel");
    public static By modalProductName = By.cssSelector(".modal-body h6.product-name");
    public static By modalProductQuantity = By.cssSelector(".modal-body span.product-quantity strong");
    public static By modalProductPrice = By.cssSelector(".modal-body p.product-price");
    public static By modalProductTotal = By.cssSelector(".modal-body p.product-total span.value");
    public static By modalFinalizarCompraButton = By.cssSelector(".modal-body .cart-content-btn a.btn.btn-primary[href*='/carrito']");
}

