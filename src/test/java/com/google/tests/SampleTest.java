package com.google.tests;

import com.google.tests.POM.SomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SampleTest {
    private WebDriver driver;
    private SomePage Page;
    private static final String appURL = "http://toolsqa.wpengine.com/automation-practice-form";

    @BeforeClass
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to(appURL);
        Page = PageFactory.initElements(driver, SomePage.class);
    }

    @Test
    public void someTest1() {
        String firstName = "Taras";
        String firstName2 = "Katya";

    //step 1
        Page.verifyEditBoxFirstNameIsEnabled(true);
        Page.setFirstName(firstName);
        Page.verifyEditboxFirstNameIsCorrect(firstName);
    }
    @Test
    public void someTest2(){
        String lastName = "Buriak";

        Page.verifyEditBoxLastNameIsEnabled(true);
        Page.setLastName(lastName);
        Page.verifyEditboxLastNameIsCorrect(lastName);
    }



    @AfterClass(enabled = true)
    public void tearDown() {
        driver.quit();
    }
}
