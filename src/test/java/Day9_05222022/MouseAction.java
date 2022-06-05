package Day9_05222022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MouseAction {
    public static void main(String[] args) throws InterruptedException {
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

        //go to Google homepage
        driver.navigate().to("https://www.USPS.com");
        Thread.sleep(3000);

        //declare and define mouse action
        Actions mouseAction = new Actions(driver);

        //hover over send tab
        WebElement sendTab = driver.findElement(By.xpath("//*[@id ='mail-ship-width']"));
        mouseAction.moveToElement(sendTab).perform();

        //click on tracking
        WebElement tracking = driver.findElement(By.xpath("//*[text()= 'Tracking']"));
        mouseAction.moveToElement(tracking).click().perform();
        Thread.sleep(2000);

        //type a invalid tracking number using send keys
        WebElement trackingField = driver.findElement(By.xpath("//*[@id = 'tracking-input'] "));
        mouseAction.moveToElement(trackingField).click().perform();
        mouseAction.moveToElement(trackingField).sendKeys("111100000").perform();


    }//end of main
}//end of java
