package Day10_052822;

import ReusableClasses.ReusableActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_Example {

    //declare the local driver outside so it can be reusable with other annotation methods
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
         driver = ReusableActions.setDriver();
    }//end of before suite annotation

    //testcase 1: naviagte to google and enter a keyword on the searchfield and submit
    @Test(priority = 1)
    public void SearchForKeyword(){
            driver.navigate().to("https://www.google.com");
            //enter a keyword on search field
            ReusableActions.sendKeysAction(driver, "//*[@name='q']", "BMW", "Search Field");
            ReusableActions.submitAction(driver, "//*[@name='btnK']", "Google Search Button");

        }//end of test 1

    //capture search #
    @Test(dependsOnMethods = "SearchForKeyword")
    public void CaptureSearchNum(){
        //capture search result
        String result = ReusableActions.getTextAction(driver, "//*[@id='result-stats']", "Search Result Text");
        //split the result by single spce and print out the search Number
        String[] arrayResult = result.split(" ");
        System.out.println("Search Number is " + arrayResult[1]);
    }//end of test 1

    //quit driver
    @AfterSuite
    public void quitSesstion(){
        driver.quit();
    }//end of aftersuite






}//end of java class
