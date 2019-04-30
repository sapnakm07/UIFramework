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
    String emptyCartDetails;

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
        }

        return productdetails;
    }

    public String clickEmptyCart()
    {
        driver.findElement(By.id("clear_cart_link")).findElement(By.name("commit")).isDisplayed();
        driver.findElement(By.id("clear_cart_link")).findElement(By.name("commit")).click();
        emptyCartDetails = driver.findElement(By.id("content")).getText();
        return emptyCartDetails;
    }

    public String clickUpdateCart()
    {
        System.out.println(("in clickUpdate"));
        System.out.println(driver.findElement(By.id("cart-detail")).getText().contains("Subtotal"));
        driver.findElement(By.id("order_line_items_attributes_0_quantity")).clear();
        driver.findElement(By.id("order_line_items_attributes_0_quantity")).sendKeys("5");

        String updatedValue= driver.findElement(By.id("order_line_items_attributes_0_quantity")).getAttribute("value");
        driver.findElement(By.id("update-button")).click();
        System.out.println(updatedValue);
        return updatedValue;
    }

    public CheckoutPage clickCheckout()
    {
        driver.findElement(By.id("checkout-link")).click();
        return new CheckoutPage(driver);

    }

}
