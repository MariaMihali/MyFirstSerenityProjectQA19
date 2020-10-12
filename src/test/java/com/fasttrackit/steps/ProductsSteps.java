package com.fasttrackit.steps;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.ProductsPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ProductsSteps {
    private HomePage homePage;
    private ProductsPage productsPage;


    @Step
    public void navigateToHomepage() {
        homePage.open();
    }


    @Step
    public void goToProductsPage() {
        homePage.clickShopLink();
    }


    @Step
    public void selectPriceAscending() {
        productsPage.selectPriceAscending("Sort by price: low to high");
    }


    @Step
    public void checkPriceAscending(){
        Assert.assertTrue(productsPage.checkProductsPrices());
    }
}


