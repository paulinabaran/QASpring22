package Day8_05212022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class gettitle {
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

        //Capture the title of the page and compare it to the expected title
        String actualTitle = driver.getTitle();
        if(actualTitle =="GOOGLE"){
            System.out.println("My title matches ");

        } else {
            System.out.println("Title doesn't match. Actual Title: " + actualTitle);
        }
    }//end of main
}// end of java
