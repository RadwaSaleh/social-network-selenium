package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginStep {
    private WebDriver driver = null;
    private String loginUrl = "https://the-internet.herokuapp.com/login";
    private ConfigFileReader configFileReader= new ConfigFileReader();
    private String username = configFileReader.getProperty("username");
    private String password = configFileReader.getProperty("password");
    private String successfulLoginMsg = "You logged into a secure area!";

    @Given("^user navigates to login page$")
    public void navigateToLoginPage() throws Throwable{
        driver = new ChromeDriver();
        driver.navigate().to(loginUrl);
    }

    @When("^user enters valid credentials$")
    public void userEntersValidCredentials( ) throws Throwable {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("^user enters invalid \"([^\"]*)\" and/or \"([^\"]*)\"$")
    public void userEntersUsernameAndPassword(String username, String password) throws Throwable {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("^user clicks login button$")
    public void userClickLoginButton() throws Throwable{
        driver.findElement(By.className("radius")).click();
    }

    @Then("^login should be unsuccessful$")
    public void validateSuccessfulLogin() throws Throwable{
        if(driver.getCurrentUrl().equalsIgnoreCase(loginUrl)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        driver.close();
    }

    @Then("^login should be successful$")
    public void checkSuccessfulLoginMessage(){
        driver.findElement(By.className("flash success")).isDisplayed();
        driver.findElement(By.className("flash success")).getText().contains(successfulLoginMsg);
        driver.close();
    }
}
