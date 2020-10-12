package com.fasttrackit.features;

import com.fasttrackit.steps.CartSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import util.BaseTest;
import util.Constants;


public class CartTest extends BaseTest {


    @Steps
    private CartSteps cartSteps;


    @Test
    public void addProductToCart() {


        cartSteps.logIntoAccount(Constants.USER_NAME,Constants.USER_PASS);
        cartSteps.goToProductsPage();
        cartSteps.addProductToCart();
        cartSteps.checkConfirmationMessage("has been added to your cart.");


    }


}


