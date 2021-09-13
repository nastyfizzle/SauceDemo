package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTest extends BaseTest{

    @Test
    public void addOneItem() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Onesie");
//        assertTrue(productsPage.removeButtonIsDisplayed("Remove"), "Button remove isn't displayed");
        //productsPage.validateNumOfProducts(1);
    }

    @Test
    public void removeOneItem() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.removeFromCart("Sauce Labs Backpack");
    }

    @Test
    public void sortDescOrderName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.selectOption("Name (Z to A)");
        List<String> names = productsPage.getProductNames();
        Assert.assertEquals(names.get(0), "Test.allTheThings() T-Shirt (Red)", "Sorting is not correctly performed");
        Assert.assertEquals(names.get(5), "Sauce Labs Backpack", "Sorting is not correctly performed");
    }

    @Test
    public void sortAscOrderName(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.selectOption("Name (A to Z)");
        List<String> names = productsPage.getProductNames();
        Assert.assertEquals(names.get(0), "Sauce Labs Backpack");
        Assert.assertEquals(names.get(5), "Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void sortAscOrderPrice(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.selectOption("Price (low to high)");
        List<String> names = productsPage.getProductNames();
        Assert.assertEquals(names.get(0), "Sauce Labs Onesie");
        Assert.assertEquals(names.get(5), "Sauce Labs Fleece Jacket");
    }

    @Test
    public void sortDescOrderPrice(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.selectOption("Price (high to low)");
        List<String> names = productsPage.getProductNames();
        Assert.assertEquals(names.get(0), "Sauce Labs Fleece Jacket");
        Assert.assertEquals(names.get(5), "Sauce Labs Onesie");
    }
}
