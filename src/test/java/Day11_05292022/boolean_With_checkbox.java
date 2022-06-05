package Day11_05292022;

import ReusableClasses.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class boolean_With_checkbox {
    //declare local webdriver so that it can be used with all annotations
    WebDriver driver;

    @BeforeSuite
    public void SetChromeDriver(){
        driver = ReusableActions.setDriver();
    }// end of before suite

    @Test(priority = 1)
    public void Yahoo_Stay_Signed_in_Checkbox() throws InterruptedException {
        //naviagte to Yahoo
        driver.navigate().to("https://www.yahoo.com");
        //click on sign in
        ReusableActions.clickAction(driver, "//*[text()='Sign in']", "Sign In");
        Thread.sleep(1500);
        //verify the stay signing in checkbox is selected or not
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
        System.out.println("Is element checked? " + elementState);
    }//end of test 1


    @AfterSuite
    public void close () {
        driver.quit();
    }//end of after suite

}// end of class






