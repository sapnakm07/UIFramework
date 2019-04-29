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

    public ShoppingCartPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public int checkShoppingCartDetails()
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
            System.out.println(lineIteminList.getText());
        }

        return productdetails;
    }


}
