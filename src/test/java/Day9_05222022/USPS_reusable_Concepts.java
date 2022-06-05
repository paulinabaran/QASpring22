package Day9_05222022;

import ReusableClasses.ReusableActions;
import org.openqa.selenium.WebDriver;

public class USPS_reusable_Concepts {
    public static void main(String[] args) {

        //setting chrome driver to reusable setDriver method
        WebDriver driver = ReusableActions.setDriver();

        driver.navigate().to("https://www.usps.com");

        //hovering over quick tools
        ReusableActions.mouseHover(driver, "//*[text() ='Quick Tools']", "Quick Tools");

        //hovering to send tab
        ReusableActions.mouseHover(driver, "//*[@id='mail-ship-width']", "Send Tab");

        //click using clickAction method
        ReusableActions.clickAction(driver, "//*[@class='tool-calc']", "Calculate a Price" );

        //input zipcode using sendKeys method
        ReusableActions.sendKeysAction(driver, "//*[@id= 'Origin']", "11385", "Zip Code");

        //
        String result = ReusableActions.getTextAction(driver, "//*[@class = 'header-usps row']", "Header Info");
        System.out.println("My result is: " + result);
    }//end of main

}//end of main

