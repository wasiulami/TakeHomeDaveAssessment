package PageObject;

import Base.Setup;
import StepDefs.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CareerPage extends Setup{
    public CareerPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        Setup.driver = driver;
    }
    @FindBy(how= How.XPATH, using = "//div[@class=\"left-side-wrapper-container\"]")
    public WebElement wholeJobList;
    @FindBy(how= How.CLASS_NAME, using = "content-wrapper-main-holder")
    public WebElement singleJob;
    public void jobExist(String jobTitle){
        String found ="";
        List<WebElement> jobList=wholeJobList.findElements(By.className(singleJob.getAttribute("class")));
        for(int i=0;i<jobList.size();i++){
            String title = jobList.get(i).findElement(By.tagName("h4")).getText();
            if(title.equals(jobTitle)){
                found =title;
                break;
            }

        }
        Assert.assertEquals(found,jobTitle,"Job not found!");



    }
    public void verifyPageTitle(){

        Assert.assertEquals(driver.getTitle(), Hook.expectedCareerPageTitle,"We are not in the Career Page!");
    }
    public void clickJobReadMore(String jobTitle){
        int temp =0;
        List<WebElement> jobList=wholeJobList.findElements(By.className(singleJob.getAttribute("class")));
        for(int i=0;i<jobList.size();i++){
            String title = jobList.get(i).findElement(By.tagName("h4")).getText();
            if(title.equals(jobTitle)){
                temp = i+1;

                break;
            }

        }

        WebElement job=driver.findElement(By.xpath("//div[@class=\"left-side-wrapper-container\"]/div["+temp+"]"));
        WebElement readMoreLink=job.findElement(By.linkText("Read more"));

        Assert.assertEquals(readMoreLink.isDisplayed(),true,"Read More Link not displaying!");
        Assert.assertEquals(readMoreLink.isEnabled(),true,"Read More Link not enabled");
        readMoreLink.click();




    }
    public void verifyJobDescription(){
        Set<String> ids= driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        Hook.careerPageID = it.next();
        Hook.jobDescriptionID = it.next();
        driver.switchTo().window(Hook.jobDescriptionID);
        String descriptionTitle = driver.getTitle().substring(12);
        Assert.assertEquals(descriptionTitle,Hook.jobTitle,"Wrong job description!");

    }
}
