package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest{

    @Test
    public void addOneItem() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.waitForElement();
        productsPage.addToCart("Sauce Labs Onesie");
        assertEquals(productsPage.getButtonText("Sauce Labs Onesie"), "REMOVE", "Text of button is wrong");
    }

    @Test
    public void removeOneItem() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.waitForElement();
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.removeFromCart("Sauce Labs Backpack");
        assertEquals(productsPage.getButtonText("Sauce Labs Backpack"), "ADD TO CART", "Text of button is wrong");
    }

    @Test
    public void sortDescOrderName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.waitForElement();
        productsPage.selectOption("Name (Z to A)");
        List<String> names = productsPage.getProductNames();
        assertEquals(names.get(0), "Test.allTheThings() T-Shirt (Red)", "Sorting is not correctly performed");
        assertEquals(names.get(5), "Sauce Labs Backpack", "Sorting is not correctly performed");
    }

    @Test
    public void sortAscOrderName(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.waitForElement();
        productsPage.selectOption("Name (A to Z)");
        List<String> names = productsPage.getProductNames();
        assertEquals(names.get(0), "Sauce Labs Backpack");
        assertEquals(names.get(5), "Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void sortAscOrderPrice(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.waitForElement();
        productsPage.selectOption("Price (low to high)");
        List<String> names = productsPage.getProductNames();
        assertEquals(names.get(0), "Sauce Labs Onesie");
        assertEquals(names.get(5), "Sauce Labs Fleece Jacket");
    }

    @Test
    public void sortDescOrderPrice(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.waitForElement();
        productsPage.selectOption("Price (high to low)");
        List<String> names = productsPage.getProductNames();
        assertEquals(names.get(0), "Sauce Labs Fleece Jacket");
        assertEquals(names.get(5), "Sauce Labs Onesie");
    }
}
