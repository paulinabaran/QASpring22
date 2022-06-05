package Day4_05072022;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args) {

        //set up Chrome Driver with webdriveremanager

       WebDriverManager.chromedriver().setup();
       //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver();

        //maximize the driver
        driver.manage().window().maximize();

        //go to Google homepage
        driver.navigate().to("https://www.google.com");


        //locate element for search field and type keywords 'cars'
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");

        //submit on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //use string to print out search result
       String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        System.out.println("Result is " + searchResult);


        //quit the driver: driver.quit();
        driver.quit();






    }//end of main



} // end of java class
