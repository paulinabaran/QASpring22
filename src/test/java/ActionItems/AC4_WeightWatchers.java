package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AC4_WeightWatchers {
    public static void main(String[] args) throws InterruptedException {
        //set up web driver
        WebDriverManager.chromedriver().setup();

        //define chrome options
        ChromeOptions options = new ChromeOptions();
        //set condition incognito mode
        options.addArguments("incognito");
        //set up fullscreen condition
        options.addArguments("start-fullscreen");

        //options.addArguments("headless");

        //define Webdriver
        WebDriver driver = new ChromeDriver(options);

        //navigate to weightwatchers
        driver.navigate().to("https://www.weightwatchers.com/us/");
        Thread.sleep(1000);

        //click on "Attend" dropdown
        try{
            //define webelement
           WebElement Attend = driver.findElements(By.xpath("//*[@class = 'MenuItem_menu-item__inner-wrapper__+m6dY']")).get(4);
           //click attend
            Attend.click();
            //click on value 'Unlimited Workshop'
            driver.findElement(By.xpath("//*[@data-e2e-name ='unlimited_workshops']")).click();
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("Unable to locate Attend dropdown " + e );
        }//end of attend exception

        //click on 'Studio'
        try{
            driver.findElement(By.xpath("//*[text() = 'Studio']")).click();
        } catch (Exception e) {
            System.out.println("Unable to located studio element " + e);
        }//end of studio exception

        //create array to add your zipcode
        try {
            ArrayList<String> zipCode = new ArrayList<>();
            zipCode.add("11385");

            for (int i = 0; i < zipCode.size(); i++) {
                driver.findElement(By.xpath("//*[@title='location-search']")).sendKeys(zipCode.get(i));
            }// end of for loop
        } catch (Exception e) {
            System.out.println("Unable to enter location" + e);
        }//end of catch

        //submit with zipcode
        try{
            driver.findElement(By.xpath("//*[@aria-label = 'Submit']")).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit " + e);
        }// end of catch

        //click on specific link for the studios
        try{
            //for loop to start
            for (int i = 0; i < 3; i++)  {
                Thread.sleep(5000); // sleep to load
                // find element to find a common name all links on page have
                List<WebElement> links = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']"));
                //naming WebElement (link) currentElement
                WebElement currentElement;
                //print out what iteration i is in and size links to know if iteration works
                System.out.println("i is: " + i + " size: " + links.size());
               if (i == 0) {
                   currentElement = links.get(1); //if this is my first iteration get the second link
               } else if (i == 1) {
                   currentElement = links.get(2); //if this is my second iteration get third link
               } else {
                   currentElement = links.get(0); //if it is neither of the two if conditions above current element becomes the 1st link
               }
               //reusable element 'scrolltoElement' is used to scroll currentElement -- (link element defined in line82)
               scrollToElement(currentElement, "element @: " + i, driver);
               //reusable element 'myClick' is used to click on currentElement --(link element defined in line82)
               myClick(currentElement, "element @: " + i);
               //load 3 seconds to link page
               Thread.sleep(3000);
               // name WebElmenet 'availableScheudle' to locate virtual Wokshop on page link
               List<WebElement> availableSchedule = driver.findElements(By.xpath("//*[@id= 'virtualWorkshopSchedule'] //div[@class='day-NhBOb']"));

               //resuable method 'scrolltoelemnt' used to scroll to availabeSchedule which is = virtual workshop schedule (line101)
                scrollToElement(availableSchedule.get(0), "available schedule" , driver);

                //create for loop to loop through each virtual workshop schedule
               for (int j = 0; j < availableSchedule.size(); j++){
                   WebElement currentSchedule = availableSchedule.get(j);
                   //after each loop print out current schedule
                   System.out.println("The virtual workshop schedule for iteration " + i + " is " + currentSchedule.getText());
               }//end of for loop to print out each virtualWorkSHopSchedule for every link

                //navigate back so system knows that is back on the pervious page
                driver.navigate().back();

           }// end of for loop, repeats until all goes through the loop
        } catch (Exception e) {
            System.out.println("Unable to click " + e);
        }//end of catch

         try {
            List<WebElement> address =  driver.findElements(By.xpath("//*[@class='address-3-YC0']"));
            for (int i = 0; i < address.size(); i++) {
                WebElement currentAddress = address.get(i);
                if (i == 0) {
                    System.out.println("My first address link is " + currentAddress.getText());
                } else if (i == 1) {
                    System.out.println("My second address link is " + currentAddress.getText());
                } else if (i == 2) {
                    System.out.println("My third address link is " + currentAddress.getText());
                }
            } // end of for loop
            } catch (Exception e) {
            System.out.println("unable to print " + e);
        }//end of try catch

    }//end of main
    public static void myClick (WebElement element, String elementName ) {
        try {
            element.click();
        } catch (Exception e)
        {
            System.out.println("unable to click " + elementName + "exception: " + e);
        }
    }

    public static void scrollToElement (WebElement element, String elementName, WebDriver myDriver) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) myDriver;
            System.out.println("attempting to scroll to element: " + elementName);
            jse.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
            Thread.sleep(5000);
        } catch (Exception e)
        {
            System.out.println("unable to scroll to element: " + elementName + "exception: " + e);
        }
    }
}// end of java class
