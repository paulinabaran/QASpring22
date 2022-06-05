package ReusableClasses;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.model.SuiteTimeInfo;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class ReusableAnnotationsClass {
    //set global variables here with public static
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    //set before suite for path and set driver
    @BeforeSuite
    public void setDriver(){
        driver = ReusableActions_Loggers.setDriver();
        //define the path to the report
        reports = new ExtentReports("src/main/java/HTML_Report/Automation.html", true);
    }//end of before suite

    //set Before method to capture test name for each @test so it can be added ot the html report later
    @BeforeMethod
    public void getTestName(Method testName){
        logger = reports.startTest(testName.getName());
    }//end of Before Method

    @AfterMethod
    public void endLogger() {
       reports.endTest(logger);
    }//end of after method

    @AfterSuite
    public void endtheSuite() {
        reports.flush();
        driver.quit();
    }//end of after suite



}//end of java class
