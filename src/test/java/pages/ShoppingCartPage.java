package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class ShoppingCartPage
{

    WebDriver driver;
    List<WebElement> cartlist;
    String productdetails;
    String updateCartValue;

    public ShoppingCartPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public int getsizeShoppingCartDetails()
    {
        cartlist = driver.findElement(By.id("cart-detail")).findElements(By.className("line-item"));
        return cartlist.size();
    }

    public String getShoppingCartDetails()
    {

        for (Iterator<WebElement> ProductinList = cartlist.iterator(); ProductinList.hasNext(); )
        {
            WebElement lineIteminList =  ProductinList.next();
            productdetails = lineIteminList.findElement(By.className("cart-item-description")).getText();
            //System.out.println(lineIteminList.getText());
        }

        return productdetails;
    }

    public void clickEmptyCart()
    {
        driver.findElement(By.name("submit")).isDisplayed();
    }

    public String clickUpdateCart()
    {
        driver.findElement(By.id("order_line_items_attributes_0_quantity")).clear();
        driver.findElement(By.id("order_line_items_attributes_0_quantity")).sendKeys("2");
        driver.findElement(By.id("update-button"));
        updateCartValue=driver.findElement(By.id("order_line_items_attributes_0_quantity")).getText();
    }
    public void clickCheckout()
    {
        driver.findElement(By.id("checkout-link")).click();
    }

}
