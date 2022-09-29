import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class loginpage{
    @FindBy(id="username")
    WebElement txtUsername;

    @FindBy(id="inputPassword")
    WebElement txtPassword;

    @FindBy(name="remember")
    WebElement remCheckbox;

    //@FindBy(className="btn btn-primary btn-login")
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement btnSubmit;

    @FindBy(xpath= "//a[@href='https://blubird.xptrackstaging.com/logout']")
     WebElement btnlogout;

    @FindBy(className = "phpdebugbar-close-btn")
    WebElement closeDebugger;
    WebDriver driver;

    public loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String dologin() throws InterruptedException {
        txtUsername.sendKeys("haris");
        Thread.sleep(1000);
        txtPassword.sendKeys("Kazi#12");
        Thread.sleep(1000);
        remCheckbox.click();
        Thread.sleep(1000);
        btnSubmit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        closeDebugger.click();
        Thread.sleep(1000);
        System.out.println(btnlogout.getText());
   //     btnlogout.click();
        return btnlogout.getText();
    }

}
