package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id="link-to-login")
    WebElement login_link;

    @FindBy(id="spree_user_email")
    WebElement user_email_id;

    @FindBy(id="spree_user_password")
    WebElement user_pwd;

    @FindBy(name = "commit")
    WebElement login_button;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,LoginPage.this);
    }

    public AddingToCart Login(String emailid, String password) {
        driver.navigate().to("https://spree-vapasi.herokuapp.com");

        login_link.click();
        user_email_id.sendKeys(emailid);
        user_pwd.sendKeys(password);
        login_button.click();
        return new AddingToCart(driver);

    }
}