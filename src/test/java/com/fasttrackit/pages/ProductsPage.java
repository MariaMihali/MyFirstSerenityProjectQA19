package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductsPage extends PageObject {

    @FindBy(css = ".header-search a")
    private WebElementFacade searchElement;


    @FindBy(css = ".search-field")
    private WebElementFacade searchField;


    @FindBy(css = ".searchsubmit")
    private WebElementFacade searchButton;


    @FindBy(css = ".entry-title > a")
    public List<WebElementFacade> searchedProducts;


    @FindBy(css = ".orderby")
    private WebElementFacade orderTypeSelector;


    @FindBy(css = "ul.products li")
    private List<WebElementFacade> listOfProducts;


    @FindBy(css = ".post-27>div.item-img")
    private WebElementFacade firstProduct;


    @FindBy(css = ".single_add_to_cart_button")
    private WebElementFacade addToCartButton;


    @FindBy(css = ".woocommerce-message")
    private WebElementFacade confirmationMessage;


    @FindBy(css = ".fa-shopping-cart")
    private WebElementFacade cartButton;




    public void searchProduct(String text) {
        clickOn(searchElement);
        clickOn(searchField);
        typeInto(searchField, text);
        clickOn(searchButton);
    }


    public boolean verifySearchedProducts(String searchKeyword) {
        boolean match = false;
        for (WebElement productNamesElement : searchedProducts) {
            if
            (productNamesElement.getText().toLowerCase().contains(searchKeyword)) {
                match = true;
            } else {
                match = false;
            }
        }
        return match;
    }


    public boolean verifyNumber(int size) {
        return searchedProducts.size() == size;
    }


    public void selectPriceAscending(String text) {
        orderTypeSelector.selectByVisibleText(text);
    }


    public boolean checkProductsPrices() {
        int priceCurrent;
        int priceNext;
        for (int i = 0; i <= listOfProducts.size() - 2; i++) {
            try {
                priceCurrent = getProductPrice(listOfProducts.get(i));
                priceNext = getProductPrice(listOfProducts.get(i + 1));


                if (priceCurrent > priceNext) {
                    return false;
                }
            } catch (NoSuchElementException e) {
            }
        }
        return true;
    }


    public int getProductPrice(WebElementFacade element) {
        String priceI = element
                .findBy(By.cssSelector(".price .amount"))
                .getText().replace(",00 lei", "").trim();
        return Integer.parseInt(priceI);
    }


    public void addProductToCart() {
        clickOn(firstProduct);
        clickOn(addToCartButton);
    }


    public boolean checkConfirmationMessage(String text) {
        return confirmationMessage.containsText(text);
    }


    public void clickCartButton() {
        clickOn(cartButton);
    }


}


