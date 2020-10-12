package com.fasttrackit.steps;

import com.fasttrackit.pages.AccountPage;
import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.ProductsPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CartSteps {

    public HomePage homePage;
    public AccountPage accountPage;
    public ProductsPage productsPage;


    @Step
    public void logIntoAccount(String email, String pass) {
        homePage.open();
        homePage.clickMyAccountTab();
        accountPage.inputEmail(email);
        accountPage.inputPass(pass);
        accountPage.clickLoginButton();
    }


    @Step
    public void goToProductsPage() {
        homePage.clickShopLink();
    }


    @Step
    public void addProductToCart() {
        productsPage.addProductToCart();
    }


    @Step
    public void checkConfirmationMessage(String text) {
        Assert.assertTrue(productsPage.checkConfirmationMessage(text));
    }
}


