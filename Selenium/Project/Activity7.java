//Adding qualifications
//Goal: Add employee qualification

package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Activity7 {
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
        driver.findElement(By.linkText("Qualifications")).click();
        //locating ADD
        driver.findElement(By.xpath("//*[@id=\"addWorkExperience\"]")).click();

        //Editing info
        WebElement Company= driver.findElement(By.xpath("//*[@id=\"experience_employer\"]"));
        Company.click();
        WebElement Job_Title = driver.findElement(By.xpath("//*[@id=\"experience_jobtitle\"]"));
        Job_Title.click();
        Company.sendKeys("IBM");
        Job_Title.sendKeys("Consultant");

        //editing duration
        WebElement FROM = driver.findElement(By.id("experience_from_date"));
        WebElement TODATE = driver.findElement(By.id("experience_to_date"));
        FROM.clear();
        FROM.sendKeys("2019-10-07");
        TODATE.clear();
        TODATE.sendKeys("2023-05-01");
        WebElement comments = driver.findElement(By.id("experience_comments"));
        comments.sendKeys("Info added");
        driver.findElement(By.id("btnWorkExpSave")).click();
        System.out.println("done");
        // Close the browser
        driver.close();
        
    }
}