package tests;

import org.openqa.selenium.By;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddingToCart;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ShoppingCartPage;

import static org.testng.Assert.assertTrue;

public class AddingToCartTest extends BaseTest{

    @Test(dataProvider = "provideInvalidCategory",groups = "smoke")
    public void VerifyInvalidCategory(String Categoryname,String sProductName)
    {
        LoginPage loginPage = new LoginPage(driver);

        ShoppingCartPage shoppingCartPage = loginPage.Login("spree@example.com", "spree123").selectCategory(Categoryname,sProductName);
        int cartlist = shoppingCartPage.getsizeShoppingCartDetails();

        System.out.println(cartlist);

    }
    @DataProvider(name="provideInvalidCategory")
    public Object[][] provideInvalidCategory()
    {
        return new Object[][]
                {
                        {"Bags And Mugs"},
                        {"Clothes"}

                };
    }

    @Test(dataProvider = "provideInvalidCategories",groups = "smoke")
    public void VerifyAllItemsInCart(String Categoryname,String sProductName)
    {
        LoginPage loginPage = new LoginPage(driver);

        ShoppingCartPage shoppingCartPage = loginPage.Login("spree@example.com", "spree123").selectCategory(Categoryname,sProductName);
        int cartlist = shoppingCartPage.getsizeShoppingCartDetails();

        System.out.println(cartlist);

        assertTrue(cartlist != 0);

        String sCartDetails = shoppingCartPage.getShoppingCartDetails();

        System.out.println(sCartDetails);
        assertTrue(sCartDetails.contains(sProductName));
    }

    @DataProvider(name="provideInvalidCategories")
    public Object[][] provideInvalidCategories()
    {
        return new Object[][]
                {
                        {"Bags","Ruby on Rails Bag"},
                        {"Mugs","Ruby on Rails Mug"},
                        {"Clothing","Ruby on Rails Baseball Jersey"}

                };
    }

   @Test(groups = "smoke")
    public void VerifyBtnUpdateCartValue()
    {
        LoginPage loginPage = new LoginPage(driver);

        ShoppingCartPage shoppingCartPage = loginPage.Login("spree@example.com", "spree123").selectCategory("Bags","Ruby on Rails Bag");

        String sUpdateCartValue = shoppingCartPage.clickUpdateCart();
        System.out.println(sUpdateCartValue);
        assertTrue(sUpdateCartValue.contains("5"));
    }

    @Test(groups = "smoke")
    public void VerifyEmptyCartButton()
    {
        LoginPage loginPage = new LoginPage(driver);
        ShoppingCartPage shoppingCartPage = loginPage.Login("spree@example.com", "spree123").selectCategory("Bags","Ruby on Rails Bag");
        String sEmptyCartDetails = shoppingCartPage.clickEmptyCart();
        assertTrue(sEmptyCartDetails.contains("Your cart is empty"));
    }

    @Test(groups = "smoke")
    public void VerifyCheckoutButton()
    {
        LoginPage loginPage = new LoginPage(driver);
        CheckoutPage checkoutPage = loginPage.Login("spree@example.com", "spree123").selectCategory("Bags","Ruby on Rails Bag").clickCheckout();
        String sCheckoutMessage = checkoutPage.CheckOutPageExists();
        //System.out.println((sCheckoutMessage));
        assertTrue(sCheckoutMessage.contains("Checkout"));
    }

    //@Test
    public void  testLogginOut()
    {
        System.out.println("in Logging Out");
    }
}
        //AddingToCart addToCart = new AddingToCart(driver);
        //addToCart.selectCategory();
        //ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        //int cartlist = shoppingCartPage.getsizeShoppingCartDetails();
        //shoppingCartPage.getShoppingCartDetails();
        //String sCartDetails = shoppingCartPage.getShoppingCartDetails();
        //assertTrue(sCartDetails.contains("Ruby on Rails Bag"));
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


    /*
    public void SelectCategory(By bags, By ruby_on_rails_bag) {
        driver.findElement(bags).click();
        driver.findElement(ruby_on_rails_bag).click();
    }
*/



