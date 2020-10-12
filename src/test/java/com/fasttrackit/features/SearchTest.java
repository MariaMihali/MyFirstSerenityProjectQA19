package com.fasttrackit.features;


import com.fasttrackit.steps.RegisterSteps;
import com.fasttrackit.steps.SearchSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import util.BaseTest;


public class SearchTest extends BaseTest {


    @Steps
    private SearchSteps searchSteps;

    @Steps
    private RegisterSteps registerSteps;


    @Test
    public void searchProductTest() {
        searchSteps.navigateToHomepage();
        searchSteps.goToProductsPage();
        searchSteps.searchProduct("cap");
        registerSteps.waitToLoad();
        searchSteps.verifyShowedProducts("cap");
    }


    @Test
    public void verifyShowedProducts() {
        searchSteps.navigateToHomepage();
        searchSteps.goToProductsPage();
        searchSteps.searchProduct("t-shirt");
        registerSteps.waitToLoad();
        searchSteps.verifyShowedProducts("t-shirt");
    }


    @Test
    public void verifyProductsNumber() {
        searchSteps.navigateToHomepage();
        searchSteps.goToProductsPage();
        searchSteps.searchProduct("t-shirt");
        searchSteps.verifyProductsNumber(3);
    }


}



