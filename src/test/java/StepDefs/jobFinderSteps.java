package StepDefs;

import Base.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        cp.verifyPageTitle();
    }

    @And("Verify that particular job opening {string} exists in the career page")
    public void verifyThatParticularJobOpeningExistsInTheCareerPage(String job) {
        cp.jobExist(job);
        Hook.jobTitle = job;



    }


    @When("I click the Read More link for the particular job")
    public void iClickTheReadMoreLinkForTheParticularJob() {
        cp.clickJobReadMore(Hook.jobTitle);

    }

    @Then("It opens up a new window containing the job description for the particular job")
    public void itOpensUpANewWindowContainingTheJobDescriptionForTheParticularJob() {
        cp.verifyJobDescription();

    }
}
