package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class AddingToCartTest extends BaseTest{

    @Test(groups = "smoke")
    public void checkitemInCart() {

        // Login to the application
        Login("spree@example.com", "spree123");

        //Select the Category
        SelectCategory(By.linkText("Bags"), By.linkText("Ruby on Rails Bag"));

        //Adding to Cart
        driver.findElement((By.id("add-to-cart-button"))).click();


        //Check Selected Item id Displayed
        System.out.println(("Cart is Displayed"));
        assertTrue(driver.findElement(By.linkText("Ruby on Rails Bag")).isDisplayed());

        assertTrue(driver.findElement(By.id("cart-detail")).findElement(By.id("line_items")).isDisplayed());

        List<WebElement> cartlist = driver.findElement(By.id("cart-detail")).findElements(By.className("line-item"));

        System.out.println(cartlist.size());

        assertTrue(cartlist.size()==1);

        for (Iterator<WebElement> ProductinList = cartlist.iterator(); ProductinList.hasNext(); ) {
            WebElement lineIteminList =  ProductinList.next();
            System.out.println(lineIteminList.findElement(By.className("cart-item-description")).getText());
            System.out.println(lineIteminList.getText());
        }

    }

    public void SelectCategory(By bags, By ruby_on_rails_bag) {
        driver.findElement(bags).click();
        driver.findElement(ruby_on_rails_bag).click();
    }

    public void Login(String emailid, String password)
    {
        driver.navigate().to("https://spree-vapasi.herokuapp.com");

        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(emailid);
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();

    }


    @Test
    public void  testLogginOut()
    {
        System.out.println("in Logging Out");
    }
}
