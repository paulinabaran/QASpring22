package ActionItems;

import ReusableClasses.ReusableActions;
import ReusableClasses.ReusableActions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AI6_PrudentialUseCase {
    //set driver so that it can be used in all annotations
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void setChromeDriver() {
        driver = ReusableActions.setDriver();
        //define where to place report
        reports = new ExtentReports("src/main/java/HTML_Report/AI6.html", true);
    } //end of Before Suite

    //US01: As a user I want to access the Retirement Calculator so that I can track my financial option
    @Test (priority = 1)
    public void startNowRC() {
        logger = reports.startTest("Start Now Retirement Calculator");
        //be redirected to 'retirement calculator page' and information on 'retirment calculator'
        driver.navigate().to("https://www.prudential.com/personal/retirement/calculator");
        //Click 'Start Now' and be redirected to page to use Retirement Calculator
        ReusableActions_Loggers.clickAction(driver, "//*[@id='leftCTA2']", logger, "Start Now");
        //switch to retirement calculator tab
        ReusableActions.switchToTabIndex(driver, 1);
        //capture tab title
        ReusableActions_Loggers.verifyTitle(driver, " Prudential Financial", logger, "tab title" );
        reports.endTest(logger);
    }//end of startnowRC test


    //US02: As a user I want to add my birthday on the calculator to establish the timeline and how much i may need for some of my financial goals
    @Test (dependsOnMethods = "startNowRC")
    public void Birthday(){

        //create array list to test multiple send keys actions
        ArrayList<String> date = new ArrayList<>();
        date.add("abc");
        date.add("08022001");

        logger = reports.startTest("Birthday");
        //correct date formatting next to 'What's your Birthday'
        ReusableActions_Loggers.verifyText(driver, "(MM/DD/YYYY)", "//*[text()= '(MM/DD/YYYY)']", logger, "Birthday Format");
        //create for loop to go through array list above in the Birthday input
        for(int i = 0; i< date.size(); i++) {
            //go through for loop to ensure: cannot type any letters and can input birthday formating
            ReusableActions_Loggers.sendKeysActionIteration(driver, "//*[@id='dateOfBirth']", date , i,  logger, "Letter Test Birthday");
        }//end of for loop

        //click continue button on next page
        ReusableActions_Loggers.clickAction(driver, "//*[@class='btn btn-block btn-primary mt-4 mb-4']", logger, "Birthday Click");
        reports.endTest(logger);
    }//end of Birthday Test

    //US03: As a user I want to add my annual income before tax to calculate my retirement needs
    @Test (dependsOnMethods = "Birthday")
    public void annualIncome () throws InterruptedException {
        //create Array List to test multiple send keys actions
        ArrayList<String> annual = new ArrayList<>();
        annual.add("abc");
        annual.add("100000");

        logger = reports.startTest("Annual Income");
        for(int i = 0; i < annual.size(); i++) {
            Thread.sleep(5000);
        //click on annual income
            ReusableActions_Loggers.clickAction(driver, "//*[@placeholder='Amount']", logger, "Annual Income");
        //loop through array list to ensure: cannot add letters can add numbers in 'Annual Income' box
            ReusableActions_Loggers.sendKeysActionIteration(driver, "//*[@placeholder='Amount']", annual, i, logger, "Letter test Annual Income");
        }//end of for loop
        reports.endTest(logger);
    }//end of annualIncome test

    //US04:As a user I want to add how much money does my household spend each month so that I can calculate my retirement needs.
    @Test (dependsOnMethods = "annualIncome")
    public void houseHold () {
        //create Array List to test multiple send keys actions
        ArrayList<String> houseHold = new ArrayList<>();
        houseHold.add("abc");
        houseHold.add("1000");

        logger = reports.startTest("Household Spending");
        for(int i = 0; i < houseHold.size(); i++) {
            //click on household spending
            ReusableActions_Loggers.clickAction(driver, "//*[@id='monthlyExpense']", logger, "Household Spending");
            //loop through array list to ensure: cannot add letters can add numbers in 'Household Spending' box
            ReusableActions_Loggers.sendKeysActionIteration(driver, "//*[@id='monthlyExpense']", houseHold, i, logger, "Letter test Household Spending");
        }//end of for loop
        reports.endTest(logger);
    }//end of annualIncome test

    //US05:As a user I want to add how much I already have saved for retirement to calculate my retirement needs
    @Test (dependsOnMethods = "houseHold")
    public void Saved () {
        //create Array List to test multiple send keys actions
        ArrayList<String> Saved = new ArrayList<>();
        Saved.add("abc");
        Saved.add("150000");

        logger = reports.startTest("Saved");
        for(int i = 0; i < Saved.size(); i++) {
            //click on 'How much have you already saved for Reiremnet?' input box
            ReusableActions_Loggers.clickAction(driver, "//*[@id='addtnlRetmntSavings']", logger, "Saved");
            //loop through array list to ensure: cannot add letters can add numbers in 'How much have you already saved for Reiremnet?' box
            ReusableActions_Loggers.sendKeysActionIteration(driver, "//*[@id='addtnlRetmntSavings']", Saved, i, logger, "Letter test Saved");
        }//end of for loop
        reports.endTest(logger);
    }//end of Saved test

    //US06: As a user I want to add how much money I invest into retirement each year to calculate my retirement needs
    @Test (dependsOnMethods = "Saved")
    public void Invest  () {
        //create Array List to test multiple send keys actions
        ArrayList<String> Invest = new ArrayList<>();
        Invest.add("abc");
        Invest.add("1000");

        logger = reports.startTest("How much money do you invest for retirement each year?");
        for(int i = 0; i < Invest.size(); i++) {
            //click on 'How much have you already saved for Reiremnet?' input box
            ReusableActions_Loggers.clickAction(driver, "//*[@id='outsideAnnlCntbAmt']", logger, "invest");
            //loop through array list to ensure: cannot add letters can add numbers in 'How much money do you invest for retirement each year?' box
            ReusableActions_Loggers.sendKeysActionIteration(driver, "//*[@id='outsideAnnlCntbAmt']", Invest, i, logger, "Letter test invest");
        }//end of for loop
        reports.endTest(logger);
    }//end of Invest test

    //quit driver
    @AfterSuite
    public void quitSession() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
        reports.flush();
    }//end of aftersuite



}//end of java class
