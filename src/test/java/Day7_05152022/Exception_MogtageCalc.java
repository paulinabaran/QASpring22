package Day7_05152022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Exception_MogtageCalc {
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
        driver.navigate().to("https://www.mlcalc.com/");
        Thread.sleep(3000);

        //handle excpetion for Price
        try{
            WebElement Price = driver.findElement(By.xpath("//* [@id = 'ma']"));
            Price.clear();
            Price.sendKeys("45000");
        }catch (Exception e) {
            //print out exception
            System.out.println("Unable to locate Purchase Price " + e);
        }//end of price exception

        //handle exception for Advanced Option button
        try{
            driver.findElement(By.xpath("//* [text() = 'Show advanced options']")).click();
        }catch (Exception e) {
            //print out exception
            System.out.println("Unable to locate Show Advance Option " + e);
        }//end of home value exception

        //handle exception for dropdown
        try{
            WebElement startMonth = driver.findElement(By.xpath("//* [@name = 'sm']"));
            Select dropdown = new Select(startMonth);
            dropdown.selectByVisibleText("Jun");
        }catch (Exception e) {
            //print out exception
            System.out.println("Unable to locate Start Month Drop Down " + e);
        }//end of dropdown exception

        //handle exception for Calculate button
        try{
            driver.findElement(By.xpath("//* [@value = 'Calculate']")).click();
        }catch (Exception e) {
            //print out exception
            System.out.println("Unable to locate Calculator button " + e);
        }//end of calculate exception
        Thread.sleep(2000);

        //handle exception for monthly payment
        try{
          String mntPayemnt = driver.findElements(By.xpath("//div[@style = 'font-size: 32px']")).get(0).getText();
          System.out.println("Monthly Payment is " + mntPayemnt);
        }catch (Exception e) {
            //print out exception
            System.out.println("Unable to locate Monthly Payment " + e);
        }//end of monthly payment exception

    }//end of main
}//end of java
