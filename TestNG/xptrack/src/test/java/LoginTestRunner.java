import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup{
    @Test
    public void userLogin() throws InterruptedException {
        loginpage login=new loginpage(driver);
        driver.get("https://blubird.xptrackstaging.com/login");
        String name= login.dologin();
        System.out.println(name);
        Assert.assertEquals(name,name);
        Assert.assertTrue(login.btnlogout.isDisplayed(), String.valueOf(true));
    }
}