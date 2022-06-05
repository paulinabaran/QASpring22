package Day7_05152022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Select_MortgageCalc {
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

        //select start month from the drop down
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));

        //define select command
        //Select dropDown = new Select(startMonth);

        //select drop down by visible text
        //dropDown.selectByVisibleText("Jun");

        //select start month from the drop down
        WebElement loanType = driver.findElement(By.xpath("//*[@name='param[milserve]']"));

        //define select command
        Select loantypedropDown = new Select(loanType);

        //select drop down by visible text
        loantypedropDown.selectByVisibleText("FHA");

        //clickingg on dropdown and its value if the dropdown is not under select tage
        startMonth.click();
        //Click on the value of the start month
        driver.findElement(By.xpath("//*[text()='Jun']")).click();






    }//send of main

}//end of java

