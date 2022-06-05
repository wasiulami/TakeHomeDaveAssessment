package StepDefs;

import Base.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import PageObject.CareerPage;
import PageObject.HomePage;

public class jobFinderSteps extends Setup {
    HomePage hp = new HomePage(driver);
    CareerPage cp = new CareerPage(driver);
    @Given("Open Dave.com")
    public void openDaveCom() {
        hp.verifyTitle();
    }

    @And("Navigate to the Careers page")
    public void navigateToTheCareersPage() {
        hp.clickCareers();
    }

    @And("Verify that particular job opening {string} exists in the career page")
    public void verifyThatParticularJobOpeningExistsInTheCareerPage(String job) {
        boolean found = cp.jobExist(job);

        Assert.assertEquals("job does not exist",found,true);


    }
}
