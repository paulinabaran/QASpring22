package ReusableClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ReusableActions {

    // reusable function for webdriver as a return method
    public static WebDriver setDriver() {
        //set up Chrome Driver with webdriveremanager
        WebDriverManager.chromedriver().setup();
        //define Chrome Option arugments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        //options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver (start-fullscreen mac)
        options.addArguments("start-fullscreen");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        return driver;
    } //end of set driver method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
        }
    }//end of mouseHover

    //create a click method
    public static void clickAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of clickAction

    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver, String xpath, String name, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(name);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of sendkeys method




    //create get text method retun mehtod to allow split
    public static String getTextAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get text " + elementName + " " + e);
        }
        return result;
    }//end of getText method

    //create select by text method
    public static void Selectbytext (WebDriver driver, String xpath,String month, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((xpath))));
            Select MonthDown = new Select(element);
            MonthDown.selectByVisibleText(month);


        } catch (Exception e) {
            System.out.println("Unable to get month " + elementName + " " + e);
        }

    }//end of select text method

    //create switch to tab by index
    public static void switchToTabIndex (WebDriver driver, int Index) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(Index));

    }//end of switch to tab by index method

    //create verify title
    public static void verifyTitle (WebDriver driver, String title , String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String actualTitle = driver.getTitle();
        try {
            if(actualTitle == title){
                System.out.println("My title matches ");

            } else {
                System.out.println("Title doesn't match. Actual Title: " + actualTitle);
            }
        } catch (Exception e) {
            System.out.println("Unable to get title " + elementName + " " + e);
        }

    }//end of verify title method

    public static void ScrolltoElement (WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            WebElement scroll = driver.findElement(By.xpath(xpath));
            jse.executeScript("arguments[0].scrollIntoView(true);",scroll);
        } catch (Exception e) {
            System.out.println("Unable to scroll to: " + elementName + " " + e);
        }

    }//end of scroll to element method

    public static void captureText (WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((xpath))));
           System.out.println("The error message:" + element.getText());

        } catch (Exception e) {
            System.out.println("Unable to Capture text of: " + elementName + " " + e);
        }

    }//end of scroll to element method


    public static void submitAction (WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((xpath))));
            element.submit();

        } catch (Exception e) {
            System.out.println("Unable submit: " + elementName + " " + e);
        }

    }//end of scroll to element method


    public static void selectTexttest (WebDriver driver, String xpath,ArrayList<String> month, int i, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {

            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((xpath))));
            Select MonthDown = new Select(element);
                MonthDown.selectByVisibleText(month.get(i));


        } catch (Exception e) {
            System.out.println("Unable to get month " + elementName + " " + e);
        }//end of selectTexttest method

    }

        public static void sendKeysIteration (WebDriver driver, String xpath, ArrayList<String> Array, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                for(int i = 0; i < Array.size(); i++ ) {
                    Thread.sleep(2000);
                    element.sendKeys(Array.get(i));
                    Thread.sleep(2000);
                    element.clear();
                }
            } catch (Exception e) {
                System.out.println("Unable to click on element " + elementName + " " + e);
            }
        }//end of sendkeys method

    public static void sendKeysIterationtest (WebDriver driver, String xpath, ArrayList<String> Array, int i, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                element.sendKeys(Array.get(i));
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of sendkeys method






    }


