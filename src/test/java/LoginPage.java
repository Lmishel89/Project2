
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPage extends BasePage {
    private WebDriver driver;
    private static final Pattern pattern = Pattern.compile(String.valueOf(Constans.VALID_EMAIL_ADDRESS_REGEX));

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void main_Page()
    {
        driver.findElement(By.className("seperator-link")).click();
        driver.findElement(By.className("text-btn")).click();
    }
    public void clickElement() {
        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        for (WebElement currentButton : buttonList) {
            if (currentButton.getText().equals("הרשמה ל-BUYME")) {
                currentButton.click();
            }
        }
    }

    public void enterCredentials() throws Exception {
        sendKeysToElement(By.id("ember1237"), Constans.FIRST_NAME);
        sendKeysToElement(By.id("ember1239"), Constans.EMAIL);
        sendKeysToElement(By.id("valPass"), Constans.PASSWORD);
        sendKeysToElement(By.id("ember1243"), Constans.PASSWORD1);
    }

    public static boolean validateEmail(String emailStr) {
        Matcher matcher= Constans.VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    public void assertTest(){

        WebElement email= driver.findElement(By.id("ember1239"));
        Assert.assertEquals(email.getAttribute("value"),Constans.EMAIL);

        WebElement firstName= driver.findElement(By.id("ember1237"));
        Assert.assertEquals(firstName.getAttribute("value"),Constans.FIRST_NAME);

        WebElement password= driver.findElement(By.id("valPass"));
        Assert.assertEquals(password.getAttribute("value"),Constans.PASSWORD);

        WebElement password1= driver.findElement(By.id("ember1243"));
        Assert.assertEquals(password1.getAttribute("value"),Constans.PASSWORD1);
    }
}



