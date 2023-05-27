//Verify that the “Directory” menu item is visible and clickable
//Goal: Verify that the “Directory” menu item is visible and clickable

package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity6 {
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
        //locate directory menu
        driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]")).click();
        // Check if it is displayed
        Boolean display = driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]")).isDisplayed();
        System.out.println("Directory menu is displayed: " +display);
        // Check if it is enabled
        Boolean enable = driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]")).isEnabled();
        System.out.println("Directory menu is enabled: " +enable);

        WebElement actualheading=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1"));
        String actualheadingtext=actualheading.getText();
        System.out.println(actualheadingtext);
        String expecteheading="Search Directory";
        Assert.assertEquals(actualheadingtext, expecteheading);
        System.out.println("Header is Serch Directory");
        // Close the browser
        driver.close();

    }
}