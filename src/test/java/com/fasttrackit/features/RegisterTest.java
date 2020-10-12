package com.fasttrackit.features;

import com.fasttrackit.steps.RegisterSteps;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import util.BaseTest;


public class RegisterTest extends BaseTest {


    @Steps
    private RegisterSteps registerSteps;


    String random = RandomStringUtils.randomAlphanumeric(10);
    @Test
    public void registerTest() {
        registerSteps.navigateToHomepage();
        registerSteps.goToMyAccountPage();
        registerSteps.enterRequiredInfo(random+"@yahoo.com", "nin1234!#R");
        registerSteps.clickRegisterButton();
        registerSteps.checkLoggedIn(random);
    }


    @Test
    public void alreadyRegisteredTest() {
        registerSteps.navigateToHomepage();
        registerSteps.goToMyAccountPage();
        registerSteps.enterRequiredInfo("maria@yahoo.com", "nin1234!#R");
        registerSteps.clickRegisterButton();
        registerSteps.waitToLoad();
        registerSteps.checkErrorMessage("Error:");
    }


    @Test
    public void invalidEmailFormat() {
        registerSteps.navigateToHomepage();
        registerSteps.goToMyAccountPage();
        registerSteps.enterRequiredInfo("maria@yahoo", "nin1234!#R");
        registerSteps.clickRegisterButton();
        registerSteps.checkErrorMessage("Error:");
    }


}


