package StepDefs;

import Base.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.util.Strings;

public class Hook extends Setup {
    public static String url;
    public static String driverType = System.getProperty("browser");
    public static String envData = System.getProperty("env");

    @Before
    public void startTest(){
        if (Strings.isNullOrEmpty(driverType)){
            driverType = "ch";
        }
        if (Strings.isNullOrEmpty(envData)){
            envData = "qa";
        }
        driver = setupBrowser(driverType);
        switch (envData){
            case "qa":
                url = "https://dave.com/";
                ;
                break;
            case "stage":
                url = "https://dave.com/";

                break;
            case "prod":
                url = "https://dave.com/";

                break;
        }
        driver.get(url);
    }

    @After
    public void endTest(Scenario scenario){
        try {
            if (scenario.isFailed()){
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // embed it in the report.
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } finally {
            driver.quit();
        }
    }
}
