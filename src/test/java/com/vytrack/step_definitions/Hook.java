package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hook {

    @Before
    public void setUp(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println(scenario.getName());
        System.out.println("BEFORE");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

    }
//    @Before (value ="@storemanager", order =1)
//    //put the priority, meaning put the order and this hook will work only for scenarios
//    // with a tag @storemanager
//    // also, it will run before default hook
//    public void setupstoreManager(Scenario scenario){
//       // System.out.println(scenario.getSourceTagNames());
//       // System.out.println(scenario.getName());
//        System.out.println("BEFORE FOR STORE MANAGER");
//    }


    @After
    public void teardown(Scenario scenario){
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image =takesScreenshot.getScreenshotAs(OutputType.BYTES);
            //we will get the screenshot and attach it
            scenario.embed(image, "image/png");
        }
        Driver.closeDriver();
System.out.println("AFTER");
    }

//    @After (value = "@storemanager", order=1)
//    public void teardownstoreManager(){
//        System.out.println("AFTER STORE MANAGER");
//    }
}
