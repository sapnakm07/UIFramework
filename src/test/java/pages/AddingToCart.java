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


    public ShoppingCartPage selectCategory()
    {
        driver.findElement(By.linkText("Bags")).click();
        driver.findElement(By.linkText("Ruby on Rails Bag")).click();
        driver.findElement((By.id("add-to-cart-button"))).click();
        return new ShoppingCartPage(driver);
    }
}
