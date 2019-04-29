package tests;

import org.openqa.selenium.By;

import org.testng.annotations.Test;
import pages.AddingToCart;
import pages.LoginPage;
import pages.ShoppingCartPage;

import static org.testng.Assert.assertTrue;

public class AddingToCartTest extends BaseTest{

    @Test(groups = "smoke")
    public void checkitemInCart() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("spree@example.com", "spree123");


        AddingToCart addToCart = new AddingToCart(driver);
        addToCart.selectCategory();


        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        int cartlist = shoppingCartPage.getsizeShoppingCartDetails();

        assertTrue(cartlist != 0);


        shoppingCartPage.getShoppingCartDetails();
        String sCartDetails = shoppingCartPage.getShoppingCartDetails();

        assertTrue(sCartDetails.contains("Ruby on Rails Bag"));




        /* Login to the application
        Login("spree@example.com", "spree123");
        Select the Category
        SelectCategory(By.linkText("Bags"), By.linkText("Ruby on Rails Bag"));
        driver.findElement((By.id("add-to-cart-button"))).click();
        Adding to Cart


        Check Selected Item id Displayed
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
        }*/
    }

    /*
    public void SelectCategory(By bags, By ruby_on_rails_bag) {
        driver.findElement(bags).click();
        driver.findElement(ruby_on_rails_bag).click();
    }
*/


    @Test
    public void  testLogginOut()
    {
        System.out.println("in Logging Out");
    }
}
