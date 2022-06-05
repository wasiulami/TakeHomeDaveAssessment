package PageObject;

import Base.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CareerPage {
    public CareerPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        Setup.driver = driver;
    }
    @FindBy(how= How.XPATH, using = "//div[@class=\"left-side-wrapper-container\"]")
    public WebElement wholeJobList;
    @FindBy(how= How.CLASS_NAME, using = "content-wrapper-main-holder")
    public WebElement singleJob;
    public boolean jobExist(String jobTitle){
        boolean found = false;
        List<WebElement> jobList=wholeJobList.findElements(By.className(singleJob.getAttribute("class")));
        for(int i=0;i<jobList.size();i++){
            String title = jobList.get(i).findElement(By.tagName("h4")).getText();
            if(title.equals(jobTitle)){
                found = true;
                break;
            }

        }
        return found;


    }
}
