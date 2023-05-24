//Get the url of the header image
//Goal: Print the url of the header image to the console

package Activities;

// Imports
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Open the page
        driver.get("http://alchemy.hguy.co/orangehrm");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());
        WebElement img=driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
        String src=img.getAttribute("src");
        System.out.println("url of the Image:"+src);

        // Close the browser
    driver.close();
    }
}