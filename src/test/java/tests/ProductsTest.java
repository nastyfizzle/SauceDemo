package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTest extends BaseTest{

    @Test
    public void addOneItem() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Onesie");
        //productsPage.validateNumOfProducts(1);
    }

    @Test
    public void removeOneItem() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.removeFromCart("Sauce Labs Backpack");
    }

    @Test
    public void sortDescOrderName() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.sortDescOrderName();
        List<String> names = productsPage.getProductNames();
        Assert.assertEquals(names.get(0), "Test.allTheThings() T-Shirt (Red)");
        Assert.assertEquals(names.get(5), "Sauce Labs Backpack");
    }

    @Test
    public void sortAscOrderName(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.sortAscOrderName();
        List<String> names = productsPage.getProductNames();
        Assert.assertEquals(names.get(0), "Sauce Labs Backpack");
        Assert.assertEquals(names.get(5), "Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void sortAscOrderPrice(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.sortAscOrderPrice();
        List<String> names = productsPage.getProductNames();
        Assert.assertEquals(names.get(0), "Sauce Labs Onesie");
        Assert.assertEquals(names.get(5), "Sauce Labs Fleece Jacket");
    }

    @Test
    public void sortDescOrderPrice(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.sortDescOrderPrice();
        List<String> names = productsPage.getProductNames();
        Assert.assertEquals(names.get(0), "Sauce Labs Fleece Jacket");
        Assert.assertEquals(names.get(5), "Sauce Labs Onesie");
    }
}
