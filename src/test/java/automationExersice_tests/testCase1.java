package automationExersice_tests;

import automationExersice_Apis.Apis;
import automationExersice_Pages.confairmaccountCreated_page;
import automationExersice_Pages.enterAccountInfo_page;
import automationExersice_Pages.homePage;
import automationExersice_Pages.logInPage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class testCase1 {
    SHAFT.GUI.WebDriver driver;
   // private static WebDriver driver;
    private homePage HomePage;
    private logInPage LogINPage;
    private enterAccountInfo_page EnterAccountInfo;
    private confairmaccountCreated_page ConfirmAccount;

    SHAFT.TestData.JSON testData;
    // JsonFileManager testData;
    SHAFT.API api;

    @Test
    public void TestCase1RegisterUser() {

        HomePage.navigateToAutomationExerciseHomePageUrl();
        HomePage.checkHomePageReached();
        HomePage.reachLoginPageFromHomePage();
        LogINPage.checkLoginPageReached();
        LogINPage.signupFromLoginPage(testData.getTestData("test1.name"), testData.getTestData("test1.email"));
        EnterAccountInfo.checkSignupPageReached();
        EnterAccountInfo.AddAccountInfo(testData.getTestData("test1.password"), Integer.parseInt(testData.getTestData("test1.days")),
                Integer.parseInt(testData.getTestData("test1.months")), Integer.parseInt(testData.getTestData("test1.years")),
                testData.getTestData("test1.fristname"), testData.getTestData("test1.lastname"),
                testData.getTestData("test1.company"), testData.getTestData("test1.address1"),
                testData.getTestData("test1.address2"), testData.getTestData("test1.state"),
                testData.getTestData("test1.city"), testData.getTestData("test1.zipcode"),
                testData.getTestData("test1.mobile")
             );

        ConfirmAccount.checkAccountCreated();
        HomePage.checkLoggedInUserName();
        HomePage.deleteUserAccount();
    }

    @Test
    public void TestCase2LoginSeams() {

        api = new SHAFT.API(Apis.baseUrl);
        automationExersice_Apis.Apis.createUser(api,"most","FakeAcc@GG.com","12345","Mr",
                 "01", "Sep", "1999", "Most", "saad", "Giza",
                "123140", "123250", "gg", "gg", "12345", "000111","000");


        HomePage.navigateToAutomationExerciseHomePageUrl();
        HomePage.checkHomePageReached();
        HomePage.reachLoginPageFromHomePage();
        LogINPage.checkLoginPageReached();
        LogINPage.logInFromLoginPage("12345","FakeAcc@GG.com");
        HomePage.checkLoggedInUserName();
        HomePage.deleteUserAccount();




    }


    /////////////////////////// Configurations

    @BeforeMethod
    public void beforeMethod() {
//        driver = new EdgeDriver();
//        driver.manage().window().maximize();
         //driver = DriverFactory.initDriver();
        driver = new SHAFT.GUI.WebDriver();
        HomePage = new homePage(driver);
        LogINPage = new logInPage(driver);
        EnterAccountInfo = new enterAccountInfo_page(driver);
        ConfirmAccount = new confairmaccountCreated_page(driver);
      //  testData = new JsonFileManager("src/test/resources/TestData.json");

    }


    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }

    @BeforeClass
    public void beforeClass() {
        //frameWork_Engine.PropertiesReader.loadProperties();
       // testData = new JsonFileManager("src/test/resources/TestData.json");

        testData = new SHAFT.TestData.JSON("src/test/resources/TestData.json");
    }


}
