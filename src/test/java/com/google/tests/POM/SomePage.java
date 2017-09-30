package com.google.tests.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class SomePage {
    @FindBy (how = How.CSS, using = "input[name = 'firstname']")
    @CacheLookup
    private WebElement editBoxFirstName;

    @FindBy (how = How.CSS, using = "input[name = 'lastname']")
    @CacheLookup
    private WebElement editBoxLastName;

    public void setFirstName(String firstName) {
        editBoxFirstName.clear();
        editBoxFirstName.sendKeys(firstName);
    }
    public void verifyEditboxFirstNameIsCorrect(String expectedFirstName) {
        String actualFirstName = editBoxFirstName.getAttribute("value");
        Assert.assertEquals(actualFirstName, expectedFirstName, "First name isn't correct");
    }

    public void verifyEditBoxFirstNameIsEnabled(boolean expected){
        boolean actual = editBoxFirstName.isEnabled();
        Assert.assertEquals(actual, expected, "First name isn't enabled.");
    }

    public void setFirstNameAndVerifyIsCorrect(String expectedFirstName, boolean expected){
        verifyEditBoxFirstNameIsEnabled(expected);
        setFirstName(expectedFirstName);
        verifyEditboxFirstNameIsCorrect(expectedFirstName);
    }

    public void setLastName(String lastName){
        editBoxLastName.clear();
        editBoxLastName.sendKeys(lastName);
    }

    public void verifyEditboxLastNameIsCorrect(String expectedLastName) {
        String actualFirstName = editBoxLastName.getAttribute("value");
        Assert.assertEquals(actualFirstName, expectedLastName, "Last name isn't correct");
    }

    public void verifyEditBoxLastNameIsEnabled(boolean expected){
        boolean actual = editBoxLastName.isEnabled();
        Assert.assertEquals(actual, expected, "Edit box 'Last name' isn't enabled.");
        
    }




}
