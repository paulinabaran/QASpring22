package Day12_06042022;

import ReusableClasses.ReusableActions_Loggers;
import ReusableClasses.ReusableAnnotationsClass;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Boolean_w_yahoo_checkbox extends ReusableAnnotationsClass {

    @Test (priority = 1)
    public void YahooCheckbox() throws InterruptedException {
        //navigate to Yahoo
        driver.navigate().to("https://www.yahoo.com");
        //click on sign in
        ReusableActions_Loggers.clickAction(driver, "//*[text()='Sign in']", logger, "Sign In");
        Thread.sleep(1500);
        //verify the stay signing in checkbox is selected or not
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
        System.out.println("Is element checked? " + elementState);
        if (elementState == true) {
            logger.log(LogStatus.PASS, "Checkbox is selected as expected");
        } else {
            logger.log(LogStatus.FAIL, "Checkbox is not selected as expected");
        }//end of if else
    }//end of test class 1

    @Test (priority = 2)
    public void NaviagtetoYahoo(){
        //navigate to yahoo homepage
        logger.log(LogStatus.INFO, "Naviagte to HomePage");
        driver.navigate().to("https://www.yahoo.com");
    }//end of test 2

}//end of java class
