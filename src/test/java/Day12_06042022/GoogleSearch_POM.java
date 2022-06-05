package Day12_06042022;

import PageObjects.BaseClass;
import ReusableClasses.ReusableAnnotationsClass;
import org.testng.annotations.Test;

public class GoogleSearch_POM extends ReusableAnnotationsClass {

    @Test
    public void SearchForAKeywordOnGoogleHome() {
        driver.navigate().to("https://www.google.com");
        BaseClass.googleHomePage().searchUserValue("BMW");
        BaseClass.googleHomePage().submitOnGoogleSearch();
    }//end of test 1

    @Test(dependsOnMethods = "SearchForAKeywordOnGoogleHome")
    public void CaptureSearchNumberFromGoogle() {
        BaseClass.googleSearchResultPage().CaptureSearchNumberandPrintit();
    }//end of test 2


}