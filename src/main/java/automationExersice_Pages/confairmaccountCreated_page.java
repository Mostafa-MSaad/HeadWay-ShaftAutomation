package automationExersice_Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class confairmaccountCreated_page {
    //private WebDriver driver;
    SHAFT.GUI.WebDriver driver;

    public confairmaccountCreated_page(SHAFT.GUI.WebDriver driver) {
        this.driver =  driver;
    }

    // Element Locators
    private final By aCCOUNTCREATEDMessage = By.xpath("//h2[@class='title text-center']//b");

    ///Validations
    public void checkAccountCreated() {
        driver.element().assertThat(aCCOUNTCREATEDMessage).text().isEqualTo("ACCOUNT CREATED!").perform();
        //Assert.assertEquals(driver.findElement(aCCOUNTCREATEDMessage).getText(),"ACCOUNT CREATED!");
    }
}
