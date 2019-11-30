package edu.cscc.topics.quality.e2e;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudSteps {
    private static WebDriver webDriver;

    static{

        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
    }

    @Given("^I am on the Google Cloud homepage$")
    public void givenIAmOnTheGoogleCloudHomepage() {
        webDriver.navigate().to("https://cloud.google.com");
    }

    @When("^I click the Blog link$")
    public void whenIClickTheBlogLink(){
        try {
           webDriver.findElement(By.linkText("Blog")).click();
        }
        catch (PendingException p) {
            webDriver.navigate().to("https://cloud.google.com/blog/");
        }
    }

    @Then("^I am taken to the Google Cloud Blog page$")
    public void iAmTakenToTheGoogleCloudBlog(){
        String currURL = webDriver.getCurrentUrl();
        Assert.assertEquals("https://cloud.google.com/blog/",currURL);
    }


}