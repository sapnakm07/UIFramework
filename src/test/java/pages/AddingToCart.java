package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddingToCart
{
    WebDriver driver;

    public AddingToCart(WebDriver driver)
        {
            this.driver=driver;
        }


    public ShoppingCartPage selectCategory(String Categoryname,String sProductName)
    {
        System.out.println(Categoryname);
        driver.findElement(By.linkText(Categoryname)).click();
       driver.findElement(By.linkText(sProductName)).click();
        driver.findElement((By.id("add-to-cart-button"))).click();
       return new ShoppingCartPage(driver);
    }
}
