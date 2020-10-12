package com.fasttrackit.features;


import com.fasttrackit.steps.CartSteps;
import com.fasttrackit.steps.CheckoutSteps;
import com.fasttrackit.steps.RegisterSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import util.BaseTest;
import util.Constants;


public class CheckoutTest extends BaseTest {

    @Steps
    private CheckoutSteps checkoutSteps;


    @Steps
    private CartSteps cartSteps;


    @Steps
    private RegisterSteps registerSteps;


    @Test
    public void checkoutTest() {
        checkoutSteps.logIntoAccount(Constants.USER_NAME, Constants.USER_PASS);
        checkoutSteps.addProductToCart();
        checkoutSteps.goToCart();
        checkoutSteps.goToCheckout();
        checkoutSteps.enterFirstName();
        checkoutSteps.enterLastName();
        checkoutSteps.selectCountry();
        checkoutSteps.enterAddress();
        checkoutSteps.enterTown();
        checkoutSteps.enterPostcode();
        checkoutSteps.enterPhoneNumber();


        registerSteps.waitToLoad();


        checkoutSteps.finishTheOrder();


        registerSteps.waitToLoad();


        checkoutSteps.checkConfirmationMessage("Order received");


    }
}

