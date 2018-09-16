package Stepdefine;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class TestSteps {
	    private static WebDriver driver = null;
	    
    @Given("^User is on (.*)$") 
    public void user_enters_HomePage(String homepage) throws Throwable {	
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\vmano\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		// Create a new instance of the Chrome driver
        driver = new ChromeDriver();
        //Put a Implicit wait, this means that the implicit wait is set for before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Launch the Amazon Website
        driver.get(homepage);
	}
	
	
    @When("^User enters SearchName for the item$")
	public void user_enters_Search_Name() throws Throwable {
    	  
    	// Find the search box and pass Nikon D3X as input
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Nikon D3X"); 
        // Now start the search with the entered text
        driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
	}
 
    @When("^User selects the second item from search results$")
	public void user_selects_Second_Item() throws Throwable {
    	  
    	// Find the second item and click
        driver.findElement(By.xpath("//*[@id=\"result_1\"]/div/div/div/div[2]/div[1]/div[1]/a/h2")).click(); 
	}
 
    @When("^User views the details$")
   	public void user_views_Second_Item() throws Throwable {
       	  
       	// Find the second item details
           String actualString = driver.findElement(By.xpath("//*[@id=\"productTitle\"]")).getText();

           String expectedString = "Nikon D3";

           assertTrue(actualString.contains(expectedString));
           
           System.out.println(actualString);
   	}
    
    
    @Then("^Message displayed Search Successful$")
	public void message_displayed_Search_Successful() throws Throwable {
		System.out.println("Search Successful");
	}
 
        // driver.quit();
 
	}

