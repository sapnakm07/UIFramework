package tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class SimpleLoginTest extends BaseTest{

    @Test(groups = "smoke")
    public void testLogin()

    {


        driver.navigate().to("https://spree-vapasi.herokuapp.com");
        //driver.get("https://spree-vapasi.herokuapp.com");
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("spree@example.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("spree123");
        driver.findElement(By.name("commit")).click();
        assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
        assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
    }

    //@Test(priority  =2)
    //public void AddingToCartTest()
    /*{
        driver.findElement((By.linkText("Bags"))).click();
        driver.findElement((By.linkText("Ruby on Rails Bag"))).click();
        if(driver.findElement((By.id("add-to-cart-button"))).isDisplayed()) {
            driver.findElement((By.id("add-to-cart-button"))).click();
        }
        assertTrue(driver.findElement(By.linkText("Ruby on Rails Bag")).isDisplayed());
    }*/



}
