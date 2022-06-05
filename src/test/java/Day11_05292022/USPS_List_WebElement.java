package Day11_05292022;

import ReusableClasses.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class USPS_List_WebElement {

    //declare local webdriver so that it can be used with all annotations
    WebDriver driver;

    @BeforeSuite
    public void SetChromeDriver(){
        driver = ReusableActions.setDriver();
    }// end of before suite

    @Test (priority = 1)
    public void USPS_Tabs_Count() throws InterruptedException {
        //naviaget to USPS
    driver.navigate().to("https://www.USPS.com");
        //declare explicit wait for tabs
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //store
        List<WebElement> tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
        //print out tab count
        System.out.println("Tab count is " + tabsCount.size());

        for (int i = 0; i < tabsCount.size(); i++) {
            //click on each tab
            driver.navigate().to("https://www.USPS.com");
            tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
            Thread.sleep(1500);
            tabsCount.get(i).click();
        }//end of for loop

    }//end of test 1


    @AfterSuite
    public void close () {
        driver.close();
    }//end of after suite

}// end of class
