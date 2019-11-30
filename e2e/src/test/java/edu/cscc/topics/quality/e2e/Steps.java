package edu.cscc.topics.quality.e2e;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Steps {
    private static WebDriver webDriver;

    static {
        /*
           Selenium can drive multiple kinds of browsers.  Chrome tends to be the most
           ubiquitous (and pretty stable).  Firefox is another good choice.  This library
           takes care of downloading a FirefoxDriver executable (which selenium uses to send
           commands to a firefox browser instance
         */
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
    }

    /*
        Note the annotation (@When).
        This step definition triggers on 'When I go to the Hello World homepage'
     */
    @Given("^I go to the Hello World homepage$")
    public void whenIGoToTheHomepage() {
        // this line tells the ChromeDriver to direct its chrome instance to http://localhost:8080/
        webDriver.navigate().to("http://localhost:8080/");
    }

    /*
        Gherkin/cucumber supports variables in step definitions.  In this instance, any text inside quotes
        is passed as the String argument 'text' to this method.
     */
    @When("^I click the link with id \\\"(.*)\\\"")
    public void clickTheLinkWithId(String text) {
        webDriver.findElement(By.id(text)).click();
    }

    @Then("^I am taken to the hello subpage")
    public void helloSubpageIsDisplayed() {
        String url = webDriver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url, "http://localhost:8080/hello");

    }

}
