package org.naic.mfl.se.challenge;

import org.testng.Assert;
import org.testng.asserts.*;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
// import the package in which "IndexPage.java" belong
//only before method and login test in converted in to POM base structure.

public class WebTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private IndexPage obj;

    @BeforeTest
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        obj = new IndexPage(driver);
        obj.openURL();
    }

    @Test
    public void signInTest() {

        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        String name = "Firstname";
        String surname = "Lastname";
        String password = "Qwerty";

        obj.signInTestMethod(email);

        obj.addDetails(name,surname,password);

        Assert.assertEquals(obj.getPageHeading(), "MY ACCOUNT");
        Assert.assertEquals(obj.getUsername(), name + " " + surname);
        Assert.assertTrue(obj.getInfoAccount().contains("Welcome to your account."));
        Assert.assertTrue(obj.getLogoutLink().isDisplayed());
        Assert.assertTrue(obj.getMyaccount().contains("controller=my-account"));
    }

    @Test
    public void logInTest() {
        //String fullName = "Joe Black";

        obj.loginTest();
        Assert.assertEquals("MY ACCOUNT", obj.getPageHeading());
        Assert.assertEquals("Joe Black", obj.getUsername());
        Assert.assertTrue(obj.getInfoAccount().contains("Welcome to your account."));
        Assert.assertTrue(obj.getLogoutLink().isDisplayed());
        Assert.assertTrue(obj.getMyaccount().contains("controller=my-account"));

    }


    @Test
    public void checkoutTest() {

        obj.loginTest();
        obj.checkout();

        Assert.assertEquals("ORDER CONFIRMATION", obj.getPageHeading());

        Assert.assertTrue(obj.getlistByClass().isDisplayed());
        Assert.assertTrue(obj.getlistByClassAndId().isDisplayed());
        Assert.assertTrue(getMessage.contains("Your order on My Store is complete."));

        Assert.assertTrue(obj.getMyaccount().contains("controller=order-confirmation"));
    }

    @AfterTest
    public void terminateBrowser(){
        driver.close();
    }

}
