package com.nttdata.stepsdefinitions;

import com.nttdata.steps.StoreProductsSteps;
import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.screenShot;

public class StoreProductsStepsDef {
    private WebDriver driver;
    private StoreProductsSteps storeProductsSteps;

    public StoreProductsStepsDef() {
        this.driver = Hooks.getDriver();
        this.storeProductsSteps = new StoreProductsSteps(driver);
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String category, String subcategory) {
        storeProductsSteps.clickClothesLink();
        screenShot();
        storeProductsSteps.clickMenLink();
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        storeProductsSteps.clickFirstProduct();
        screenShot();
        storeProductsSteps.increaseQuantityToTwo();
        screenShot();
        storeProductsSteps.addProductToCart();
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        boolean isModalDisplayed = storeProductsSteps.validateModalIsDisplayed();
        Assert.assertTrue("El modal de confirmación no se mostró", isModalDisplayed);

        String modalTitle = storeProductsSteps.getModalTitle();
        Assert.assertTrue("El título del modal no contiene el mensaje esperado",
                modalTitle.contains("Producto añadido correctamente"));

        String productName = storeProductsSteps.getModalProductName();
        Assert.assertFalse("El nombre del producto está vacío", productName.isEmpty());

        String quantity = storeProductsSteps.getModalProductQuantity();
        Assert.assertEquals("La cantidad no es 2", "2", quantity);

        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        boolean isCalculationCorrect = storeProductsSteps.validateTotalCalculation();
        Assert.assertTrue("El cálculo del total no es correcto", isCalculationCorrect);
        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        storeProductsSteps.clickFinalizarCompraButton();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        String cartTitle = storeProductsSteps.getCartPageTitle();
        Assert.assertTrue("El título de la página del carrito no es correcto",
                cartTitle.equalsIgnoreCase("Carrito"));
        screenShot();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        boolean isCalculationCorrect = storeProductsSteps.validateCartTotalCalculation();
        Assert.assertTrue("El cálculo del total en el carrito no es correcto", isCalculationCorrect);
        screenShot();
    }

}
