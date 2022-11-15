import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowserTest {

    //Creating main method
    public static void main(String[] args) {

        // Declaring String type local variable
        String baseUrl = "http://the-internet.herokuapp.com/login";

        //1. Setting up the browser
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");

        //Object creation of Interface
        WebDriver driverEdge = new EdgeDriver();

        //2. Opening given URL
        driverEdge.get(baseUrl);

        //Maximising Edge window upon opening
        driverEdge.manage().window().maximize();

        //Timeout for page to load
        driverEdge.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Print the title of page
        System.out.println("The title of page is: " + driverEdge.getTitle());

        //4. Print the current URL
        String currentUrl = driverEdge.getCurrentUrl();
        System.out.println("The current URL is: " + currentUrl);

        //5. Print the page source
        System.out.println("Source code of page: " + driverEdge.getPageSource());

        //6. Enter the username in username field
        WebElement userNameF = driverEdge.findElement(By.id("username"));
        userNameF.sendKeys("jay123");

        //7. Enter the password in the password field
        WebElement passField = driverEdge.findElement(By.name("password"));
        passField.sendKeys("pass@123");

        //8. Closing the Edge browser
        driverEdge.quit();


    }


}
