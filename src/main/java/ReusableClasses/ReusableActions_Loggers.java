package ReusableClasses;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ReusableActions_Loggers {

    //set a static timeout variable so it can cover all explicit for all methods
    public static int timeout = 30;

    //resuable function for webdriver as a return method
    public static WebDriver setDriver(){
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setDriver method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
        }
    }//end of mouseHover

    //create a click method
    public static void clickAction(WebDriver driver,String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS,"Successfully click on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to sclick on element " + elementName + " " + e);
        }
    }//end of clickAction

    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS,"Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit


    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver,String xpath, String userValue, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully enter user value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter user value on element " + elementName + " " + e);
        }
    }//end of sendkeys method

    //create a getText method
    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = "";
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully capture text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " + e);
        }
        return result;
    }//end of getTextAction method

    //create a click by index method
    public static void clickByIndexAction(WebDriver driver,String xpath, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of clickByIndexAction

    public static void sendKeysActionIteration(WebDriver driver,String xpath, ArrayList<String> Array, int i, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(Array.get(i));
            logger.log(LogStatus.PASS,"Successfully enter user value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter user value on element " + elementName + " " + e);
        }
    }//end of sendkeys method


    public static void clearAction(WebDriver driver,String xpath, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            logger.log(LogStatus.PASS,"Successfully cleared value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to clear element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to clear element " + elementName + " " + e);
        }
    }//end of sendkeys method

    //create verify title
    public static void verifyTitle (WebDriver driver, String title , ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String actualTitle = driver.getTitle();
        try {
            if(actualTitle == title){
                System.out.println("My title matches ");

            } else {
                System.out.println("Title doesn't match. Actual Title: " + actualTitle);
            }
            logger.log(LogStatus.PASS,"title on " + elementName + "MATCHES");
        } catch (Exception e) {
            System.out.println("Unable to get title " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"title on " + elementName + " Dosen't Match " + " " + e);
        }

    }//end of verify title method

    public static void verifyText (WebDriver driver, String actualText , String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((xpath))));
            element.getText();
            if(actualText == element.getText()){
                System.out.println("My Text matches ");

            } else {
                System.out.println("Text doesn't match. text: " + actualText);
            }  logger.log(LogStatus.PASS,"text on " + elementName + " MATCHES");
        } catch (Exception e) {
            System.out.println("Unable to get text " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"text on " + elementName + "Dosen't Match " + " " + e);
        }

    }//end of verify text method

    public static void verifyStatusOfElement(WebDriver driver, String xpath, Boolean expectedStatus, ExtentTest logger, String ElementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            Boolean actualStatus = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
            if(expectedStatus == actualStatus){
                logger.log(LogStatus.PASS,"Element is selected as expected");
            } else {
                logger.log(LogStatus.FAIL,"Element is not selected");
            }
        } catch (Exception e) {
            System.out.println("Unable to check checkbox " + e );
        }
    }//end of method

}//end of class