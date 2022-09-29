import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

    public class UserPage {

// Declaring ANSI_RESET so that we can reset the color
        public static final String ANSI_RESET = "\u001B[0m";
// Declaring the color
        public static final String ANSI_Red = "\u001B[31m";
        public static final String ANSI_Green = "\u001B[32m";

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
        public void UserPage() throws InterruptedException {
            driver.get("https://telaeris.xptrack.com/login");
            WebElement txtUsername = driver.findElement(By.id("username"));
            txtUsername.sendKeys("haris2022");
            WebElement txtPassword = driver.findElement(By.id("inputPassword"));
            txtPassword.sendKeys("32bit.PNG!!");
            driver.findElement(By.cssSelector("[type=submit]")).click();
            Thread.sleep(1000);

// Navigate to the User Menu

            List<WebElement> userMenu = driver.findElements(By.className("title"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            userMenu.get(0).click();

//Test Case1: Check Any User is selected or Not
            List<WebElement> firstUserSelect = driver.findElements(By.className("user"));
            if (firstUserSelect.get(0).isEnabled()) {
                String SelectedUserName = firstUserSelect.get(0).getText();
                System.out.println("Selected User Name is:  " + SelectedUserName);
                System.out.println(ANSI_Green+"Test Case 1 is Passed"+ANSI_Green);
            } else {
                System.out.println("Test Case 1 is Failed");
            }
            Thread.sleep(3000);

//Test Case2:  Add New User
     driver.findElement(By.id("add_new_user_button")).click();
     driver.findElement(By.id("user_save_button")).click();
     WebElement ErrorMessage = driver.findElement(By.id("error_message"));
     String txtErrorMessage = ErrorMessage.getText();
     if (txtErrorMessage.contains("First name is required" + "\n" + "Last name is required" + "\n" + "Email is required")) {
     System.out.println(ANSI_Green +"Required Field validation check is Passed"+ ANSI_RESET);
     }
     else {
     System.out.println(ANSI_Red + "Required Field validation is wrong"+ ANSI_RESET);
      }

     WebElement firstName = driver.findElement(By.id("first_name"));
             firstName.sendKeys("Hasan");
     driver.findElement(By.id("last_name")).sendKeys("Abul");

   WebElement RoleDropdown = driver.findElement(By.id("select2-role_id-container"));
   RoleDropdown.click();
            Thread.sleep(1000);
   List<WebElement> SelectGuestRole= driver.findElements(By.className("select2-results__option")) ;
   SelectGuestRole.get(5).click();
            Thread.sleep(1000);
            driver.findElement(By.id("is_active")).click();

     driver.findElement(By.id("user_save_button")).click();
     if(driver.findElement(By.xpath("//div[contains(@class,'toast-message')]")).isDisplayed());
     {
         System.out.println(ANSI_Green +"Test Case is Passed"+ ANSI_RESET);
            }

        }

        @After
        public void closeDriver() {
            //driver.close();
            // driver.quit();
        }
    }