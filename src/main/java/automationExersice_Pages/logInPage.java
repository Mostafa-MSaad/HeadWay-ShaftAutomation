package automationExersice_Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class logInPage {
   // private WebDriver driver;
    SHAFT.GUI.WebDriver driver;

    public logInPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Element Locators
    private final By newUserSignupFormTittle = By.xpath("//div[@class='signup-form']//h2");
    private final By newUserSignupName = By.xpath("//input[@data-qa='signup-name']");
    private final By newUserSignupEmail = By.xpath("//input[@data-qa='signup-email']");
    private final By newUserSignupButton = By.xpath("//button[@data-qa='signup-button']");


    private final By userLogInPassword = By.xpath("//input[@data-qa='login-password']");
    private final By userLogInEmail = By.xpath("//input[@data-qa='login-email']");
    private final By userLogInButton = By.xpath("//button[@data-qa='login-button']");

    //////actions
    public void checkLoginPageReached() {
        driver.element().assertThat(newUserSignupFormTittle).text().isEqualTo("New User Signup!").perform();

       // Assert.assertEquals(driver.findElement(newUserSignupFormTittle).getText(),"New User Signup!");
    }


    public void signupFromLoginPage(String name,String Email) {
        driver.element().type(newUserSignupName,name);
        driver.element().type(newUserSignupEmail,Email);
        driver.element().click(newUserSignupButton);
        // driver.findElement(newUserSignupName).sendKeys(name);
       // driver.findElement(newUserSignupEmail).sendKeys(Email);
      //  driver.findElement(newUserSignupButton).click();
    }
    public void logInFromLoginPage(String Password,String Email) {
        driver.element().type(userLogInPassword,Password);
        driver.element().type(userLogInEmail,Email);
        driver.element().click(userLogInButton);

    }
}
