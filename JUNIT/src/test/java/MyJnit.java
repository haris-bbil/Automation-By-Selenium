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

public class MyJnit {
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
    @Test
           public void getTitle() {

                  driver.get("https://mm-dev.blubirdinteractive.org/")  ;
                  String title = driver.getTitle()   ;
                  System.out.println(title);
 //                 Assert.assertEquals( "Toolsqa",title);
                                  }

    @Test
    public void checkIfImageExists() throws InterruptedException {
        driver.get("https://demoqa.com/");
//        WebElement image1= driver.findElement(By.cssSelector("img"));
//        Assert.assertTrue(String.valueOf(image1.isDisplayed()),true);
        Thread.sleep(20000);
        WebElement image2 = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
        Assert.assertTrue (String.valueOf(image2.isDisplayed()), true);

    }
    @After

           public void closeBrowser() {
                  driver.close() ;
 //                 driver.quit();
                                      }

}

                       