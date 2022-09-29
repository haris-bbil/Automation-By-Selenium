import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.List;

public class LoginTest {

    WebDriver driver;
    @Before

    public void setup() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

//    @Test
//    public void getTitile() {
//        driver.get("https://blubird.xptrackstaging.com/login")  ;
//        String title = driver.getTitle()   ;
//        System.out.println(title);
//        Assert.assertEquals("Telaeris Inc. Login Form", title);
//    }
    @Test
    public void loginSys() throws InterruptedException {
        driver.get("https://telaeris.xptrack.com/login") ;

 // Login with wrong Username & Password
        WebElement txtUsername = driver.findElement(By.id("username"));
        txtUsername.sendKeys("haris2312312");
        Thread.sleep(1000);
        WebElement txtPassword = driver.findElement(By.id("inputPassword"));
        txtPassword.sendKeys("Kazi45sadsadasd");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[type=submit]")).click();
        Thread.sleep(2000 );

//  Login with Correct Username and Incorrect Password
        WebElement txtUsername2 = driver.findElement(By.id("username"));
        txtUsername2.clear();
        Thread.sleep(1500);
        txtUsername2.sendKeys("haris2022");
        Thread.sleep(1000);
        WebElement txtPassword2 = driver.findElement(By.id("inputPassword"));
        txtPassword2.sendKeys("Kazi45sadsadasd");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[type=submit]")).click();
        Thread.sleep(2000 );

// Login with Correct username & password
        WebElement txtPassword3 = driver.findElement(By.cssSelector("[type= password]"));
        txtPassword3.sendKeys("32bit.PNG!!");
        Thread.sleep(2000);
        WebElement CheckBox = driver.findElement(By.name("remember"));
        CheckBox.click();
        driver.findElement(By.cssSelector("[type=submit]")).click();
        Thread.sleep(2000);

// Check navigate to the Correct URL or Not
        String getUrl = driver.getCurrentUrl();
        Assert.assertTrue(getUrl.contains("https://telaeris.xptrack.com/muster"));
        System.out.println(getUrl);  //Print  validationMessage ;

// Navigate to the User Menu
        List<WebElement> userMenu= driver.findElements(By.className("title"));
        userMenu.get(0).click();
        Thread.sleep(3000 );

    }

    @After
    public void closeDriver() {
        //driver.close();
        // driver.quit();
    }

}

