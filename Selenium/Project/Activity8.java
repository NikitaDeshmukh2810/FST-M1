//Applying for a leave
//Goal: Login and apply for a leave on the HRM site

package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Activity8 {
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
        //locating DASHBOARD
        //driver.findElement(By.id("menu_dashboard_index")).click();
        //FIND apply leave
        driver.navigate().to("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/dashboard");
        WebElement applyleave = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/span"));
        applyleave.click();
        //Editing info
        WebElement selectleavetype = driver.findElement(By.id("applyleave_txtLeaveType"));
        // Pass the WebElement to the Select object
        Select Selecttype = new Select(selectleavetype);
        // Select "Javascript" using visible text
        Selecttype.selectByVisibleText("DayOff");
        WebElement FROM = driver.findElement(By.id("applyleave_txtFromDate"));
        WebElement TODATE = driver.findElement(By.id("applyleave_txtToDate"));
        FROM.clear();
        FROM.sendKeys("2023-08-20");
        TODATE.clear();
        TODATE.sendKeys("2023-08-25");
        WebElement comments = driver.findElement(By.id("applyleave_txtComment"));
        comments.sendKeys("leave applied");
        driver.findElement(By.id("applyBtn")).click();
        System.out.println("done");
        // Close the browser
        driver.close();


    }
}