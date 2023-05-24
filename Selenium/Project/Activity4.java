//Logging into the site
//Goal: Open the site and login with the credentials provided
//Add a new employee
//Goal: Add an employee and their details to the site

package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;

public class Activity4 {
    public static void main(String[] args) throws InterruptedException {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("http://alchemy.hguy.co/orangehrm");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the username field and enter the username
        driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("orange");
        // Find the password field and enter the password
        driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("orangepassword123");
        // Find the login button and click it
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        // Click PIM
        Thread.sleep(3);
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]")).click();
        // Click Add
        driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
        //Find the Required Fields
        WebElement FirstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        WebElement MiddleName = driver.findElement(By.xpath("//*[@id=\"middleName\"]"));
        WebElement LastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        //Enter the Information
        // Type credentials
        FirstName.sendKeys("Nita");
        MiddleName.sendKeys("Adi");
        LastName.sendKeys("Deshmukh");
        //Click save
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
        driver.navigate().to("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/pim/viewPimModule");
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewEmployeeList\"]")).click();
        Thread.sleep(10);

        WebElement Empid = driver.findElement(By.xpath("//*[@id=\"empsearch_id\"]"));
        Empid.click();
        Empid.sendKeys("1317");
        Thread.sleep(200);
        driver.findElement(By.cssSelector("#searchBtn")).click();
        // Close the browser
        driver.close();
    }
}