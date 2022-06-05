package Day7_05152022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
import java.util.ArrayList;

public class FidelisCare_Tabs {
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
        driver.navigate().to("https://www.fideliscare.org/");
        Thread.sleep(3000);

        //click on shop for a plan
        driver.findElements(By.xpath("//*[text() = 'Shop For a Plan']")).get(0).click();
        Thread.sleep(1000);

        //click on Medicaid Managed Care
        driver.findElements(By.xpath("//*[text() ='Medicaid Managed Care']")).get(0).click();
        Thread.sleep(1000);

        //click on Serach for Doctor to open a new tab
        driver.findElement(By.xpath("//*[@href = '/findadoctor']")).click();

        //store new tab in an arraylist, we use getWindowHandles to get list of tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //switch to new tab, it should be at index 1
        driver.switchTo().window(tabs.get(1));

        //click on New search button
        driver.findElements(By.xpath("//*[@class = 'fal fa-search-plus']")).get(0).click();
        Thread.sleep(1000);

        //close just the new tab
        driver.close();

        //switch back to default tab
        driver.switchTo().window(tabs.get(0));




    }//end of main
}//end of java
