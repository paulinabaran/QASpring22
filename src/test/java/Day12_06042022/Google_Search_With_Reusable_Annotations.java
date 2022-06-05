package Day12_06042022;

import ReusableClasses.ReusableActions;
import ReusableClasses.ReusableActions_Loggers;
import ReusableClasses.ReusableAnnotationsClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Google_Search_With_Reusable_Annotations extends ReusableAnnotationsClass {

    //testcase 1: naviagte to google and enter a keyword on the searchfield and submit
    @Test(priority = 1)
    public void SearchForKeyword(){
        driver.navigate().to("https://www.google.com");
        //enter a keyword on search field
        ReusableActions_Loggers.sendKeysAction(driver, "//*[@name='q']", "BMW", logger,"Search Field");
        //Submit search
        ReusableActions_Loggers.submitAction(driver, "//*[@name='btnK']", logger, "Google Search Button");
        //end the logger per test

    }//end of test 1

    //capture search #
    @Test(dependsOnMethods = "SearchForKeyword")
    public void CaptureSearchNum(){
        //capture search result
        String result = ReusableActions_Loggers.getTextAction(driver, "//*[@id='result-stats']", logger, "Search Result Text");
        //split the result by single spce and print out the search Number
        String[] arrayResult = result.split(" ");
        System.out.println("Search Number is " + arrayResult[1]);
        logger.log(LogStatus.INFO, "Search Number is " + arrayResult[1]);
    }//end of test 2



}//end of java class