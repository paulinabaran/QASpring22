package PageObjects;

import ReusableClasses.ReusableActions_POMLoggers;
import ReusableClasses.ReusableAnnotationsClass;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleHomePage extends ReusableAnnotationsClass {
    //delcare the Extent Test for each page object class
    ExtentTest logger;

    //create a constructor method that will reference the same name as your class so you can make your
    //page object class static when you call it in your test class
    public GoogleHomePage(WebDriver driver){
        //page factory fc for page object
        PageFactory.initElements(driver, this);
        this.logger = ReusableAnnotationsClass.logger;
    }//end of constructor

    //define all the WebElmenets using @find by concept
    @FindBy(xpath = "//*[@name ='q']")
    WebElement searchField;
    @FindBy(xpath = "//*[@name='btnK']")
    WebElement googleSearchFunction;
    @FindBy(xpath = "//*[@name='btnK']")
    List<WebElement> listlinks; //used with findelements concept

    public void searchUserValue(String userValue){
        ReusableActions_POMLoggers.sendKeysAction(driver,searchField,"uservalue",logger,"Search Field");
    }//end of searchUserValue

    public void submitOnGoogleSearch () {
        ReusableActions_POMLoggers.submitAction(driver, googleSearchFunction, logger, "Submit");
    }//end of submit on google search

}




