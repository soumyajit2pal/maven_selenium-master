package com.lazerycode.selenium.tests;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.GoogleHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        // WebElement mouserhover = driver.findElement(By.xpath(".//span[.='Hello, Sign in']"));
        // actions.moveToElement(mouserhover).perform();
// click to Sign In button
        driver.findElement(By.xpath(".//span[.='Sign in']")).click();
// wait untill login window not visible
        // WebDriverWait wait=new WebDriverWait(driver, 120);
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Email')]"))));
    //    send email id and then click to continue

        System.out.println(driver.findElement(By.xpath(".//*[contains(text(),'Login')]]")).getText() +" Page is loaded");

        driver.findElement(By.xpath(".//*[@type='email']")).sendKeys("soumyajit2pal@gmail.com");
        driver.findElement(By.xpath(".//span[.='Continue']")).click();

        WebDriverWait wait=new WebDriverWait(driver, 120);

        driver.findElement(By.xpath(".//*[@type='password']")).sendKeys("Bhaddru@2020");
        driver.findElement(By.xpath(".//span[.='Login']")).click();

        System.out.println(driver.findElement(By.xpath("//span[@id='nav-your-amazon-text']")).getText() +" is visbile");

        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox' and @type='text']")).sendKeys("JBL C100SI In-Ear Deep Bass Headphones with Mic (Black)");
        driver.findElement(By.xpath("//*[@type='submit' and @value='Go']")).click();
    }
} 