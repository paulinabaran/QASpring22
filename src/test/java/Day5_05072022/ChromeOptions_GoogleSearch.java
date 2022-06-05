package Day5_05072022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptions_GoogleSearch {
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
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);

        //locate element for search field and type keywords 'cars'
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");

        //submit on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //use string to print out search result
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        System.out.println("Result is " + searchResult);

        //quit the driver
        driver.quit();

    }// end of main

}//end of Java Class
