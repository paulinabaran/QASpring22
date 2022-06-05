package Day5_05072022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Forloop_ArrayList_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {


        //capture search number and print for the following citites using arraylist and for loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn ");
        cities.add("Queens ");
        cities.add("Bronx ");

        //set up Chrome Driver with webdriveremanager
        WebDriverManager.chromedriver().setup();

        //define Chrome Option arugments
        ChromeOptions options = new ChromeOptions();

        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver (start-fullscreen mac)
        options.addArguments("start-fullscreen");
        //options.addArguments("headless");

        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        for (int i = 0; i < cities.size(); i++) {

            //go to Google homepage
            driver.navigate().to("https://www.google.com");
            Thread.sleep(3000);

            //locate element for search field and type keywords 'cars'
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities.get(i));


            //submit on google search button
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            //use string to print out search result
            String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
           //System.out.println("Result is " + searchResult);
            // using split to print out a specific keyword from searchResult driver
            String[] arrayResult = searchResult.split(" ");
            System.out.println("My search number for city " + cities.get(i) + arrayResult[1]);

        } //end of for loop

        //quit the driver
       // driver.quit();







    } //end of main

}// end of java
