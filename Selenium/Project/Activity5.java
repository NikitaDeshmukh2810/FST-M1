//Edit user information
//Goal: Edit a user’s information

//Logging into the site
//Goal: Open the site and login with the credentials provided


package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Activity5 {
    public static void main(String[] args) {
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
        //My info tab
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]")).click();
        //Edit
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
        //Editing info
        WebElement FirstName = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]"));
        WebElement LastName = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpLastName\"]"));
        FirstName.clear();
        FirstName.sendKeys("Names");
        LastName.clear();
        LastName.sendKeys("Adidas");
        //Gender radio
        WebElement Malegender = driver.findElement(By.xpath("//*[@id=\"personal_optGender_1\"]"));
        Malegender.click();
        WebElement FeMalegender = driver.findElement(By.xpath("//*[@id=\"personal_optGender_2\"]"));
        //Malegender.click();
        //Editing nationality
        // Find the dropdown
        WebElement selectNatinality = driver.findElement(By.id("personal_cmbNation"));
        // Pass the WebElement to the Select object
        Select IndiSelect = new Select(selectNatinality);
        // Select "Javascript" using visible text
        IndiSelect.selectByVisibleText("Indian");
        //editing DOB
        WebElement DOB = driver.findElement(By.id("personal_DOB"));
        DOB.clear();
        DOB.sendKeys("1997-10-07");
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
        // Close the browser
        driver.close();
    }
}