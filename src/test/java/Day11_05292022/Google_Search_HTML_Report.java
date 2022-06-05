package Day11_05292022;

import ReusableClasses.ReusableActions;
import ReusableClasses.ReusableActions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Google_Search_HTML_Report {

    //declare the local driver outside so it can be reusable with other annotation methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;


    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver = ReusableActions.setDriver();
        //define the path to the report
       reports = new ExtentReports("src/main/java/HTML_Report/Automation.html", true);
    }//end of before suite annotation

    //testcase 1: naviagte to google and enter a keyword on the searchfield and submit
    @Test(priority = 1)
    public void SearchForKeyword(){
        logger = reports.startTest("Search for a keyword");
        driver.navigate().to("https://www.google.com");
        //enter a keyword on search field
        ReusableActions_Loggers.sendKeysAction(driver, "//*[@name='q']", "BMW", logger,"Search Field");
        //Submit search
        ReusableActions_Loggers.submitAction(driver, "//*[@name='btnK']", logger, "Google Search Button");
        //end the logger per test
        reports.endTest(logger);
    }//end of test 1

    //capture search #
    @Test(dependsOnMethods = "SearchForKeyword")
    public void CaptureSearchNum(){
        logger = reports.startTest("Capture Search Number");
        //capture search result
        String result = ReusableActions_Loggers.getTextAction(driver, "//*[@id='result-stats']", logger, "Search Result Text");
        //split the result by single spce and print out the search Number
        String[] arrayResult = result.split(" ");
        System.out.println("Search Number is " + arrayResult[1]);
        logger.log(LogStatus.INFO, "Search Number is " + arrayResult[1]);
        //end the logger per test
        reports.endTest(logger);
    }//end of test 2

    //quit driver
    @AfterSuite
    public void quitSesstion(){
        driver.quit();
        reports.flush();

    }//end of aftersuite






}//end of java class