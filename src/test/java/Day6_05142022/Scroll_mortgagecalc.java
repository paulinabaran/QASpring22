package Day6_05142022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scroll_mortgagecalc {
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
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);

        //define java script executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Scroll down
        //jse.executeScript("scroll(0,400)");
        //define WebElement
        WebElement shareButton = driver.findElement(By.xpath("//*[@id='share_button']"));

        //scroll to specific elment on page
        jse.executeScript("arguments[0].scrollIntoView(true);",shareButton);
        Thread.sleep(2000);

        //click share button
        shareButton.click();
        Thread.sleep(2000);

        //scroll back up
        jse.executeScript("scroll(0, -400)");
        Thread.sleep(2000);

    }//end of main
}//end of java
