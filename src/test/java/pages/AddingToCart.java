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


    public void selectCategory(By bags, By ruby_on_rails_bag, By id)
    {
        driver.findElement(bags).click();
        driver.findElement(ruby_on_rails_bag).click();
        driver.findElement((By.id("add-to-cart-button"))).click();

    }
}
