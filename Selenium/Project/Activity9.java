//Retrieve emergency contacts
//Goal: Login and retrieve the emergency contacts for the user

package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Activity9 {
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
        driver.navigate().to("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/pim/viewMyDetails");
        //FIND Emergency contact
        driver.findElement(By.linkText("Emergency Contacts")).click();

        // get all the table row elements from the table
        List<WebElement> allrows = driver.findElements(By.xpath("//table[@class='table hover']//tr"));
        // Iterate over them and get all the cells
        for(WebElement row:allrows){
            List<WebElement> cells=row.findElements(By.tagName("td"));
        //print the contents of each cell
            for(WebElement cell:cells){
                System.out.println(cell.getText());
            }
        }
        // Close the browser
        //driver.close();
    }
    }