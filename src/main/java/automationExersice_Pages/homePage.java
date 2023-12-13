package automationExersice_Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class homePage {
    //private WebDriver driver;
    SHAFT.GUI.WebDriver driver;
    public homePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    String automationExerciseHomePageUrl = "http://automationexercise.com";

    // Element Locators
    private final By homepage_featuredItemsTittle = By.xpath("(//h2[@class='title text-center'])[1]");
    private final By logInButton = By.xpath("//a[@href='/login']");
    private final By loggedInUser = By.cssSelector("a>b");
    private final By deleteUser = By.xpath("//a[@href='/delete_account']");


    //////Actions
    public void navigateToAutomationExerciseHomePageUrl() {
        driver.browser().navigateToURL(automationExerciseHomePageUrl);
       // driver.navigate().to(automationExerciseHomePageUrl);
    }

    public void checkHomePageReached() {
        driver.element().assertThat(homepage_featuredItemsTittle).text().isEqualTo("FEATURES ITEMS").perform();
       // Assert.assertEquals(driver.findElement(homepage_featuredItemsTittle).getText(),"FEATURES ITEMS");
    }

    public void reachLoginPageFromHomePage() {
        driver.element().click(logInButton);
        //driver.findElement(logInButton).click();
    }
    public void checkLoggedInUserName() {
        driver.element().assertThat(loggedInUser).text().isEqualTo("most").perform();
    }
    public void deleteUserAccount() {
        driver.element().click(deleteUser);
    }
}
