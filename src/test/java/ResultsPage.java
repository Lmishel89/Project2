import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.regex.Pattern;

public class ResultsPage extends BasePage{
    private final WebDriver driver;
    private static final Pattern pattern = Pattern.compile(String.valueOf(Constans.VALID_EMAIL_ADDRESS_REGEX));

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement()
    {
        WebElement selectBusiness= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[1]/a/div"));
        selectBusiness.click();
            }
    public void chooseAmount() throws Exception {
        sendKeysToElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/div/div/input"),"270" );
    }

    public void chooseChief()
    {
       WebElement button= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div[2]/form/div[2]/div/button"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div[2]/form/div[2]/div/button")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div[2]/form/div[2]/div/button")));
        clickElement(button);
        }
    }



