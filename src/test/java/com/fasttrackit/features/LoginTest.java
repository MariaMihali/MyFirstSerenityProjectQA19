package com.fasttrackit.features;


import com.fasttrackit.steps.LoginSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import util.BaseTest;
import util.Constants;


public class LoginTest extends BaseTest {


        @Steps
        private LoginSteps loginSteps;


        @Test
        public void validCredentialsLoginTest() {
            loginSteps.navigateToHomepage();
            loginSteps.goToMyAccountPage();
            loginSteps.enterRequiredInfo(Constants.USER_NAME, Constants.USER_PASS);
            loginSteps.clickRememberMeCheckbox();
            loginSteps.clickLoginButton();
            loginSteps.checkLoggedIn("maria");
        }


        @Test
        public void invalidEmailLoginTest() {
            loginSteps.navigateToHomepage();
            loginSteps.goToMyAccountPage();
            loginSteps.enterRequiredInfo("mari@yahoo.com", Constants.USER_PASS);
            loginSteps.clickRememberMeCheckbox();
            loginSteps.clickLoginButton();
            loginSteps.checkEmailErrorMsg();
        }


        @Test
        public void invalidPassLoginTest() {
            loginSteps.navigateToHomepage();
            loginSteps.goToMyAccountPage();
            loginSteps.enterRequiredInfo(Constants.USER_NAME, "nin1234#R");
            loginSteps.clickRememberMeCheckbox();
            loginSteps.clickLoginButton();
            loginSteps.checkPassErrorMsg();


        }




    }

