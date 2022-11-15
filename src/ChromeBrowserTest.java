import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTest {
    //Creating main method
    public static void main(String[] args) {
        //Declaring a local variable of String type
        String baseUrl = "http://the-internet.herokuapp.com/login";

        //1. Setting up the Chrome browser
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        // Creating an interface object
        WebDriver driverCh = new ChromeDriver();

        //2. Opening given URL
        driverCh.get(baseUrl);

        //Maximise browser upon opening
        driverCh.manage().window().maximize();

        //Time given to driver to wait until page is loaded completely
        driverCh.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Get & print title page in console
        String title = driverCh.getTitle();
        System.out.println("Page title is: " + title);

        //4. Get & print the current page URL in console
        String currUrl = driverCh.getCurrentUrl();
        System.out.println("Current URL is: " + currUrl);

        //5. Print the page source code in console
        System.out.println("The source code is : " + driverCh.getPageSource());

        //6. Getting web element and entering username in username field
        WebElement userName = driverCh.findElement(By.id("username"));
        userName.sendKeys("nik222");

        //7. Getting web element and entering password in password field
        WebElement passdField = driverCh.findElement(By.id("password"));
        passdField.sendKeys("xyz_123");

        //8. Closing the Chrome browser
        driverCh.quit();
    }
}
