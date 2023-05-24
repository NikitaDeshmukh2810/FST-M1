//Verify the website title
//Goal: Read the title of the website and verify the text

package Activities;

// Imports
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("http://alchemy.hguy.co/orangehrm");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());
        String expectedTitle= "OrangeHRM";
        String title= driver.getTitle();
        if (title.equalsIgnoreCase(expectedTitle)){
            System.out.println("Title Matched");
            driver.close();
        }else{
            System.out.println("Title not Matched");
        }

        // Close the browser

    }
}