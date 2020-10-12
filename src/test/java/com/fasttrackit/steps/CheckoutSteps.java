package com.fasttrackit.steps;

import com.fasttrackit.pages.*;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CheckoutSteps {
    public HomePage homePage;
    public AccountPage accountPage;
    public ProductsPage productsPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;


    @Step
    public void logIntoAccount(String email, String pass) {
        homePage.open();
        homePage.clickMyAccountTab();
        accountPage.inputEmail(email);
        accountPage.inputPass(pass);
        accountPage.clickLoginButton();
    }


    @Step
    public void addProductToCart() {
        homePage.clickShopLink();
        productsPage.addProductToCart();
    }


    @Step
    public void goToCart() {
        productsPage.clickCartButton();
    }


    @Step
    public void goToCheckout() {
        cartPage.proceedToCheckout();
    }


    @Step
    public void enterFirstName() {
        checkoutPage.enterFirstName("Maria");
    }


    @Step
    public void enterLastName() {
        checkoutPage.enterLastName("Mihali");
    }


    @Step
    public void selectCountry() {
        checkoutPage.selectCountry("Romania");
    }


    @Step
    public void enterAddress() {
        checkoutPage.enterAddress("Str. Cerbului, Nr. 9");
    }


    @Step
    public void enterTown() {
        checkoutPage.enterTown("Borsa");
    }


    @Step
    public void enterPostcode() {
        checkoutPage.enterPostCode("400591");
    }


    @Step
    public void enterPhoneNumber() {
        checkoutPage.enterPhoneNumber("0747025022");
    }


    @Step
    public void finishTheOrder() {
        checkoutPage.clickOrderButton();
    }


    @Step
    public void checkConfirmationMessage(String text) {
        Assert.assertTrue(checkoutPage.checkOrderConfirmation(text));
    }
}




