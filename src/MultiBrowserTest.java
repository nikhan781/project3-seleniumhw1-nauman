import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {

    // Declaring global variables
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static String selectBrowser = "Chrome";
    static WebDriver mDriver;

    public static void main(String[] args) {

        //1. Setting up the select browser via if-else condition statement
        if (selectBrowser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            mDriver = new ChromeDriver();
        } else if (selectBrowser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");
            mDriver = new FirefoxDriver();
        } else if (selectBrowser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            mDriver = new EdgeDriver();
        } else {
            System.out.println("Invalid Browser");
        }
        // Handling the null pointer exception due to invalid entry
        try {
            //2. Opening the selected browser
            mDriver.get(baseUrl);
        } catch (Exception e) {
            System.exit(0);
        }
        //Maximising selected window upon opening
        mDriver.manage().window().maximize();

        //Timeout for page to load completely
        mDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Printing the title of page
        String pageTitle = mDriver.getTitle();
        System.out.println("The title of page is: " + pageTitle);

        //4. Printing the current URL
        System.out.println("The current URL is: " + mDriver.getCurrentUrl());

        //5. Printing the page source
        System.out.println("Source code of page: " + mDriver.getPageSource());

        //6. Entering the username in username field
        WebElement usNameField = mDriver.findElement(By.id("username"));
        usNameField.sendKeys("jitu123");

        //7. Entering the password in the password field
        WebElement passField = mDriver.findElement(By.name("password"));
        passField.sendKeys("pass@989");

        //8. Closing the selected browser
        mDriver.quit();


    }
}
