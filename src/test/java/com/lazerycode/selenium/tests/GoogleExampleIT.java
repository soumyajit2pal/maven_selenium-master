package com.lazerycode.selenium.tests;
import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.GoogleHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import java.util.NoSuchElementException;

public class GoogleExampleIT extends DriverBase {

    private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
    }

    @Test
    public void googleCheeseExample() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        GoogleHomePage googleHomePage = new GoogleHomePage();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        //googleHomePage.enterSearchTerm("Cheese")
        //        .submitSearch();

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        //WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        //wait.until(pageTitleStartsWith("Cheese"));

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void googleMilkExample() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit Google
        driver.get("https://www.amazon.in/");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        GoogleHomePage googleHomePage = new GoogleHomePage();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        //googleHomePage.enterSearchTerm("Milk")
        //        .submitSearch();

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        //WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        //wait.until(pageTitleStartsWith("Milk"));

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());


        driver.findElement(By.xpath(".//span[.='Hello, Sign in']")).click();

        driver.findElement(By.xpath(".//*[@type='email']")).sendKeys("soumyajit2pal@gmail.com");
        WebDriverWait wait=new WebDriverWait(driver, 120);
        driver.findElement(By.xpath("//*[@id='continue']")).click();

        wait=new WebDriverWait(driver, 120);

        driver.findElement(By.xpath(".//*[@type='password']")).sendKeys("Wrong@2020");
        driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();

        try{
            driver.findElement(By.xpath(".//*[contains(text(),'Password')]"));
            System.out.println("****Sign In failed due to wrong password****");
          }catch(NoSuchElementException exception){
            System.out.println("Sign In !!");
          }       

    }
}