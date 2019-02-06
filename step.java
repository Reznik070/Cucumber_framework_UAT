package Steps;		

import org.openqa.selenium.By;	
import org.openqa.selenium.*;	
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
//import cucumber.api.java.en.When;		
import cucumber.api.java.en.And;		

public class step {				

    WebDriver driver;
    
    @Given("^the user goes to website$")
    
    public void open_the_Chrome_and_launch_the_application() throws Throwable							
    {		
       System.setProperty("webdriver.chrome.driver","C:\\Users\\Akino\\eclipse-workspace\\Drivers\\chromedriver.exe");					
       driver= new ChromeDriver();					
       driver.manage().window().maximize();			
       driver.get("http://automationpractice.com/index.php");					
    }		
    
    @And("^clicks the login link$")
    
    public void click_Login() throws Throwable
    {
    
    WebElement loginlink = driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a"));
    loginlink.click(); 
    
    }
    
    @And("^enter email$")
    
    public void usrname() throws Throwable
    
    {
    
	WebElement emil = driver.findElement(By.cssSelector("#email"));
	emil.sendKeys("akemzo07@hotmail.com");
	}
    
    @And("^enter password$")

    public void pass() throws Throwable

    {

    WebElement password = driver.findElement(By.cssSelector("#passwd"));
    password.sendKeys("rocker07");
    } 
  
     @And("^clicks login button$")

    public void loinbtn() throws Throwable

    {

    WebElement logbtn = driver.findElement(By.cssSelector("#SubmitLogin > span"));
    logbtn.click();
    }
    
   
    @Then("^the user is logged in$")

    public void logged() throws Throwable

    {

    //driver.findElement(By.cssSelector("body > div > table:nth-child(5) > tbody > tr:nth-child(2) > td > form > input[type=\"submit\"]:nth-child(3)"));
    driver.getPageSource().contains("MY ACCOUNNT");
    
    String expectedTitle = "My account - My Store";
    String actualTitle = "";
    actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle, expectedTitle);
    
    driver.close();


   }  

}
    
    
    
    
 