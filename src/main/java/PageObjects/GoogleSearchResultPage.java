package PageObjects;

import ReusableClasses.ReusableActions_POMLoggers;
import ReusableClasses.ReusableAnnotationsClass;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultPage extends ReusableAnnotationsClass {
    //delcare the Extent Test for each page object class
    ExtentTest logger;

    //create a constructor method that will reference the same name as your class so you can make your
    //page object class static when you call it in your test class
    public GoogleSearchResultPage(WebDriver driver){
        //page factory fc for page object
        PageFactory.initElements(driver, this);
        this.logger = ReusableAnnotationsClass.logger;
    }//end of constructor

    //define all the WebElmenets using @find by concept
    @FindBy(xpath = "//*[@id='result-stats']")
    WebElement searchResult;

    public void CaptureSearchNumberandPrintit () {
        String result= ReusableActions_POMLoggers.getTextAction(driver, searchResult, logger,"Seach Result");
    }//end of capture search number and print it

}//end of java class