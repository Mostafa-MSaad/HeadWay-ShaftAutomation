package automationExersice_Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class enterAccountInfo_page {
   // private WebDriver driver;
    SHAFT.GUI.WebDriver driver;

    public enterAccountInfo_page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    // Element Locators

    private final By eNTERACCOUNTINFORMATIONTitle = By.xpath("(//h2[@class='title text-center']//b)[1]");
    private final By titleRadioButtonMR = By.id("id_gender1");
    private final By password = By.id("password");
    private final By days = By.id("days");
    private final By months = By.id("months");
    private final By years = By.id("years");
    private final By newsletterCheck = By.id("newsletter");
    private final By specialOffersCheck = By.id("optin");

    private final By firstname = By.id("first_name");
    private final By lastname = By.id("last_name");
    private final By company = By.id("company");

    private final By address1 = By.id("address1");

    private final By address2 = By.id("address2");
    private final By state = By.id("state");

    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobile_number = By.id("mobile_number");
    private final By country = By.id("country");
    private final By createAccountButton = By.xpath("//button[@data-qa='create-account']");


    /////actions
    public void checkSignupPageReached() {
    driver.element().assertThat(eNTERACCOUNTINFORMATIONTitle).text().isEqualTo("ENTER ACCOUNT INFORMATION").perform();
        //Assert.assertEquals(driver.findElement(eNTERACCOUNTINFORMATIONTitle).getText(),"ENTER ACCOUNT INFORMATION");
    }


    public void AddAccountInfo(String Password, int daysI, int monthsI, int yearsI, String fristName,String lastName,String Company,
                               String Address1,String Address2,String State,String City,String Zipcode,String Mobilenumber) {


        driver.element().click(titleRadioButtonMR);
      //  driver.findElement(titleRadioButtonMR).click();
        driver.element().type(password, Password);
      //  driver.findElement(password).sendKeys(Password);


        ///driver.element().scrollToElement(createAccountButton);
        driver.element().keyPress(titleRadioButtonMR, Keys.PAGE_DOWN);


        Select mySelect1= new Select(driver.getDriver().findElement(days));
        mySelect1.selectByIndex(daysI);

        Select mySelect2= new Select(driver.getDriver().findElement(months));
        mySelect2.selectByIndex(monthsI);

        Select mySelect3= new Select(driver.getDriver().findElement(years));
        mySelect3.selectByIndex(yearsI);



        driver.element().click(newsletterCheck);
        //driver.findElement(newsletterCheck).click();
        driver.element().click(specialOffersCheck);
        //driver.findElement(specialOffersCheck).click();




        driver.element().type(firstname,fristName);
        //driver.findElement(firstname).sendKeys(fristName);
        driver.element().type(lastname,lastName);
        //driver.findElement(lastname).sendKeys(lastName);
        driver.element().type(company,Company);
        //driver.findElement(company).sendKeys(Company);



        driver.element().type(address1,Address1);
        //driver.findElement(address1).sendKeys(Address1);
        driver.element().type(address2,Address2);
        //driver.findElement(address2).sendKeys(Address2);
        driver.element().type(state,State);
        //driver.findElement(state).sendKeys(State);


        driver.element().type(city,City);
        //driver.findElement(city).sendKeys(City);
        driver.element().type(zipcode,Zipcode);
        //driver.findElement(zipcode).sendKeys(Zipcode);
        driver.element().type(mobile_number,Mobilenumber);
        //driver.findElement(mobile_number).sendKeys(Mobilenumber);


        driver.element().keyPress(createAccountButton, Keys.PAGE_DOWN);


        Select mySelect4= new Select(driver.getDriver().findElement(country));
        mySelect4.selectByIndex(0);
        //driver.findElement(createAccountButton).click();
        driver.element().click(createAccountButton);


    }
}
