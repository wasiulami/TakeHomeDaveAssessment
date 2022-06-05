package PageObject;

import Base.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends Setup{
    public HomePage (WebDriver driver){
        PageFactory.initElements(driver, this);
        Setup.driver = driver;
    }
    @FindBy(how= How.LINK_TEXT, using = "Careers")
    public WebElement careerPageButton;
    public void verifyTitle(){
        String expectedTitle = "Dave - Mobile Banking App - Cash Advance, Budget, Build Credit";
        Assert.assertEquals(expectedTitle,driver.getTitle(),"Not in the correct homepage!");

    }
    public void clickCareers(){
        careerPageButton.click();
    }


}
