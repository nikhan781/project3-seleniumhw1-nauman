import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxBrowserTest {

    //Creating the main method of the class
    public static void main(String[] args) {
        //Declaring String type local variable
        String baseUrl = "http://the-internet.herokuapp.com/login";

        //2. Setting up the browser
        System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");

        // Creating object of Interface
        WebDriver driverFire = new FirefoxDriver();

        //2. Opening the URL
        driverFire.get(baseUrl);

        // Maximising the browser window
        driverFire.manage().window().maximize();

        //Timeout to load the webpage
        driverFire.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. Printing the page title in the console
        System.out.println("Page title is: " + driverFire.getTitle());

        //4. Print current URL
        System.out.println("The current URL is: " + driverFire.getCurrentUrl());

        //5. Print page source code
        String sourceC = driverFire.getPageSource();
        System.out.println("The source code is: " + sourceC);

        //6. Getting and entering username
        WebElement usName = driverFire.findElement(By.id("username"));
        usName.sendKeys("hiren321");

        //7. Getting and entering password
        WebElement passField = driverFire.findElement(By.id("password"));
        passField.sendKeys("pass000");

        //8. Closing the FireFox browser
       driverFire.quit();


    }
}
