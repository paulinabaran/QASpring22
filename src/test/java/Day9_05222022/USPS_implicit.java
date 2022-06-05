package Day9_05222022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class USPS_implicit {
    public static void main(String[] args) {
        //set up Chrome Driver with webdriveremanager
        WebDriverManager.chromedriver().setup();

        //define Chrome Option arugments
        ChromeOptions options = new ChromeOptions();

        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver (start-fullscreen mac)
        options.addArguments("start-fullscreen");

        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        //global set implicit weight
        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //go to USPS
        driver.navigate().to("https://www.USPS.com");

        //call mouse actions
        Actions actions = new Actions(driver);

        //declare explicit weight
        WebDriverWait wait = new WebDriverWait(driver, 8);

        //hover to quick tools
        WebElement quicktools = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() ='Quick Tools']")));
        actions.moveToElement(quicktools).perform();

        //click on track package
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Track a Package']"))).click();

        //click and then type of track package field
        WebElement packageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'tracking-input']")));
        packageField.sendKeys("11231234");




    }//end of main
}//end of java
