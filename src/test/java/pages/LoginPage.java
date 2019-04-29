package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public AddingToCart Login(String emailid, String password) {
        driver.navigate().to("https://spree-vapasi.herokuapp.com");

        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(emailid);
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();
        return new AddingToCart(driver);

    }
}