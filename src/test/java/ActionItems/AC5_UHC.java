package ActionItems;

import ReusableClasses.ReusableActions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class AC5_UHC {
    public static void main(String[] args) throws InterruptedException {
        //calling on define webdrive method
        WebDriver driver = ReusableActions.setDriver();

        //declare First Name array list
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Eddie");
        firstName.add("Bob");
        firstName.add("Paulina");

        //declare Last Name array list
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Thomas");
        lastName.add("Roger");
        lastName.add("Baran");

        //declare Month Array List
        ArrayList<String> month = new ArrayList<>();
        month.add("November");
        month.add("December");
        month.add("August");



        //declare Date Array List
        ArrayList<String> date = new ArrayList<>();
        date.add("20");
        date.add("15");
        date.add("2");

        //declare Year Array List
        ArrayList<String> year = new ArrayList<>();
        year.add("1999");
        year.add("2000");
        year.add("2001");

        //declare zipCode Array List
        ArrayList<String> zipCode= new ArrayList<>();
        zipCode.add("11356");
        zipCode.add("11234");
        zipCode.add("11385");

        //declare MemberId Array List
        ArrayList<String> memberID = new ArrayList<>();
        memberID.add("22021233");
        memberID.add("44592000");
        memberID.add("34123445");

for (int i = 0; i < 3; i++ ) {

    //navigate to UHC website
    driver.navigate().to("https://www.uhc.com/");

    //calling on verifyTitle method to confirm title
    ReusableActions.verifyTitle(driver, "Health insurance plans", "Verify Title");

    //calling on click method to click on 'Find a Doctor'
    ReusableActions.clickAction(driver, "//*[@aria-label='Find a doctor']", "Find a Doctor");

    //calling on click method to click 'Sign in'
    ReusableActions.clickAction(driver, "//*[@aria-label='Sign in menu']", "Sign in");

    //calling on click method to click 'Medicaid plan?'
    ReusableActions.clickAction(driver, "//*[text()='Medicare plan?']", "Medicaid plan?");

    //calling on switchtotabindex to switch to new tab
    ReusableActions.switchToTabIndex(driver, 1);

    //calling on click method to click 'register now'
    ReusableActions.clickAction(driver, "//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']", "Regsiter now");

    //calling on click method to click Fist name box
    ReusableActions.clickAction(driver, "//*[@id='firstName']", "First Name Click");

    //calling on SendKeys method to enter firstnames
    ReusableActions.sendKeysIterationtest(driver, "//*[@id='firstName']", firstName, i, "First Name");

    //calling on click method to click Last name boc
    ReusableActions.clickAction(driver, "//*[@id='lastName']", "Last Name Click");

    //calling on sendkeys to iterate through last names
    ReusableActions.sendKeysIterationtest(driver, "//*[@id='lastName']", lastName, i, "Last Name");

    //calling on click method to click month
    ReusableActions.clickAction(driver, "//*[@id='dob_month_input']", "Month Drop Down");

    //calling on select text test method to select month and iterate through them
    ReusableActions.selectTexttest(driver, "//*[@id='dob_month_input']", month, i, "Month");

    //calling on click method to click DD
    ReusableActions.clickAction(driver, "//*[@id='dob_day']", "Date");

    //calling on send keys iteration method to type dates
    ReusableActions.sendKeysIterationtest(driver, "//*[@id='dob_day']", date, i, "date");

    //calling on click method to click year
    ReusableActions.clickAction(driver, "//*[@id='dob_year']", "Year");

    //calling on send keys method iteration to iterate through years
    ReusableActions.sendKeysIterationtest(driver, "//*[@id='dob_year']", year, i, "date");

    //calling on click method to click Zipcode
    ReusableActions.clickAction(driver, "//*[@id='zipCode']", "ZipCode");

    //calling on send keys iteration method to iterate through Zipcodes
    ReusableActions.sendKeysIterationtest(driver, "//*[@id='zipCode']", zipCode, i, "zipCode");

    //calling on send keys action after iterations to have something in input box
    //ReusableActions.sendKeysAction(driver,"//*[@id='zipCode']", "11385", "Zipcode" );

    //calling on click method to click MemberID
    ReusableActions.clickAction(driver, "//*[@id='memberId']", "MemberID");

    //calling on send keys iteration to iterate through MemberIDs
    ReusableActions.sendKeysIterationtest(driver, "//*[@id='memberId']", memberID, i, "Member ID");

    //calling on Scroll to element method to scroll to 'Continue button'
    ReusableActions.ScrolltoElement(driver, "//*[@id='submitBtn']", "Scroll to Element");

    //calling on click method to click 'Continue' button
    ReusableActions.clickAction(driver, "//*[@id='submitBtn']", "Continue");

    //calling on CaptureText method to capture error message
    ReusableActions.captureText(driver, "//*[@id='plainText_error']", "Error Message");

    //close tab
    driver.close();

    //calling on switchtotabindex to switch to original tab
    ReusableActions.switchToTabIndex(driver, 0);

}
    }//end of main
}//end of java
