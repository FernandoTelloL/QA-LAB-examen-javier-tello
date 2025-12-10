package com.nttdata.steps;

import com.nttdata.page.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoreProductsSteps {
    private final WebDriver driver;

    public StoreProductsSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void clickClothesLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));

        wait.until(ExpectedConditions.presenceOfElementLocated(
                StoreProductsPage.clothesCategory
        ));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        WebElement clothesLink = driver.findElement(StoreProductsPage.clothesCategory);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                clothesLink
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clothesLink);

        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void clickMenLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement menLink = wait.until(
                ExpectedConditions.elementToBeClickable(StoreClothesPage.menCategory)
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menLink);

        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void clickFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstProductElement = wait.until(
                ExpectedConditions.elementToBeClickable(StoreMenPage.firstProduct)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                firstProductElement
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstProductElement);

        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void increaseQuantityToTwo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement increaseButton = wait.until(
                ExpectedConditions.elementToBeClickable(StoreProductDetailPage.increaseQuantityButton)
        );

        increaseButton.click();

        wait.until(ExpectedConditions.attributeToBe(
                StoreProductDetailPage.quantityInput,
                "value",
                "2"
        ));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void addProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(StoreProductDetailPage.addToCartButton));

        WebElement addToCartBtn = wait.until(
                ExpectedConditions.elementToBeClickable(StoreProductDetailPage.addToCartButton)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                addToCartBtn
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean validateModalIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement modal = wait.until(
                ExpectedConditions.visibilityOfElementLocated(StoreModalPage.modalCart)
        );

        return modal.isDisplayed();
    }

    public String getModalTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement modalTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(StoreModalPage.modalTitle)
        );

        return modalTitle.getText();
    }

    public String getModalProductName() {
        WebElement productName = driver.findElement(StoreModalPage.modalProductName);
        return productName.getText();
    }

    public String getModalProductQuantity() {
        WebElement productQuantity = driver.findElement(StoreModalPage.modalProductQuantity);
        return productQuantity.getText();
    }

    public String getModalProductPrice() {
        WebElement productPrice = driver.findElement(StoreModalPage.modalProductPrice);
        return productPrice.getText();
    }

    public String getModalProductTotal() {
        WebElement productTotal = driver.findElement(StoreModalPage.modalProductTotal);
        return productTotal.getText();
    }

    public boolean validateTotalCalculation() {
        String priceText = getModalProductPrice();
        String quantityText = getModalProductQuantity();
        String totalText = getModalProductTotal();

        double unitPrice = parsePrice(priceText);
        int quantity = Integer.parseInt(quantityText.trim());
        double total = parsePrice(totalText);

        double expectedTotal = unitPrice * quantity;

        return Math.abs(expectedTotal - total) < 0.01;
    }

    private double parsePrice(String priceText) {
        String cleanPrice = priceText.replace("S/", "")
                .replace("&nbsp;", "")
                .replace("\u00a0", "")
                .replace(" ", "")
                .trim();
        return Double.parseDouble(cleanPrice);
    }

    public void clickFinalizarCompraButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement finalizarCompraBtn = wait.until(
                ExpectedConditions.elementToBeClickable(StoreModalPage.modalFinalizarCompraButton)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                finalizarCompraBtn
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", finalizarCompraBtn);

        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getCartPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement cartTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(StoreCartPage.cartTitle)
        );

        return cartTitle.getText();
    }

    public String getCartProductUnitPrice() {
        WebElement unitPrice = driver.findElement(StoreCartPage.productUnitPrice);
        return unitPrice.getText();
    }

    public String getCartProductQuantity() {
        WebElement quantity = driver.findElement(StoreCartPage.productQuantity);
        return quantity.getAttribute("value");
    }

    public String getCartTotalInclTax() {
        WebElement total = driver.findElement(StoreCartPage.cartTotalInclTax);
        return total.getText();
    }

    public boolean validateCartTotalCalculation() {
        String unitPriceText = getCartProductUnitPrice();
        String quantityText = getCartProductQuantity();
        String totalText = getCartTotalInclTax();

        double unitPrice = parsePrice(unitPriceText);
        int quantity = Integer.parseInt(quantityText.trim());
        double total = parsePrice(totalText);

        double expectedTotal = unitPrice * quantity;

        return Math.abs(expectedTotal - total) < 0.01;
    }
}
