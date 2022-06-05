package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem3_SeleniumwithWebdriver {
    public static void main(String[] args) throws InterruptedException {

        //using array list and for loop capture the following city variables
        ArrayList<String> cities = new ArrayList<>();
        cities.add(" Queens Village ");
        cities.add(" Middle Village ");
        cities.add(" Garden City ");


        //setup Chrome webdriver
        WebDriverManager.chromedriver().setup();

        //define chrome option arugment
        ChromeOptions options = new ChromeOptions();

        //setup maximize condition to webdriver
        options.addArguments("start-fullscreen");

       //options.addArguments("headless");

        //define webdriver
        WebDriver driver = new ChromeDriver(options);

        //add for loop
       for (int i = 0; i < cities.size(); i++) {

            //naviagte to bing homepafe
            driver.navigate().to("https://www.bing.com/" );
            //slow down executiuon
            Thread.sleep(3000);

            //locate element for searchbar and go through cities array list with forloop

            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities.get(i));

            //submit of bing search button
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();
            //slow down executiuon
            Thread.sleep(3000);

            //use string to print out search result
            String searchResult = driver.findElement(By.xpath("//*[@id='b_tween']")).getText();

            //use a split command to select a specif keyword
            String[] arrayResult = searchResult.split(" ");

            //print out only search number for each value
            System.out.println("My Search result for the city" + cities.get(i) + arrayResult[0]);


        } // end of for loop

        //close webdriver
        driver.quit();




    }//end of main
}//end of java
