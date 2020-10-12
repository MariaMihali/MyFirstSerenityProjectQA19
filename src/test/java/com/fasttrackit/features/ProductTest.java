package com.fasttrackit.features;
import com.fasttrackit.steps.ProductsSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import util.BaseTest;

public class ProductTest extends BaseTest {

        @Steps
        private ProductsSteps productSteps;


        @Test
        public void sortByPrice() {
            productSteps.navigateToHomepage();
            productSteps.goToProductsPage();
            productSteps.selectPriceAscending();
            productSteps.checkPriceAscending();
        }

        }
