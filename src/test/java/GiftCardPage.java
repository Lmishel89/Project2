import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.PublicKey;
import java.time.Duration;
import java.util.List;

public class GiftCardPage extends BasePage  {
    private WebDriver driver;
    public GiftCardPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickElement() {
        WebElement checkboxSendNotToMe = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/label[1]"));
        checkboxSendNotToMe.click();
        //takeElementScreenshot(checkboxSendNotToMe);
    }
        public void receiverAndSenderName() throws Exception {
        sendKeysToElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[2]/label[1]/input"), "Ronen");
        WebElement sender =driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[2]/label[2]/input"));
        sender.clear();
        sendKeysToElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[2]/label[2]/input"), "LenuraM");
            }
        public void blessingMessage() throws Exception {
        WebElement blessingField = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[3]/label[2]/textarea"));
        blessingField.clear();
        //takeElementScreenshot(blessingField);
        sendKeysToElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[3]/label[2]/textarea"), "It seems like it was only yesterday that we were playing together and here we are! It seems like a dream! I wish you a happy married life ahead and that all your dreams come true!\n" +
                "\n" +
                "Dear brother, well done on finding your true love! No matter where you are in life, I will always be with you! My best wishes for a wonderful life with your new family!");
        }

        public void insertScreenShot() throws Exception {
        sendKeysToElement(By.name("fileUpload"),"C:\\Users\\Lena\\screenShots\\screenShot1.jpg");
    }
    public void whenToSend() {
        WebElement checkboxSendItRightNow = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div[1]/label[1]"));
        clickElement(checkboxSendItRightNow);
        // takeElementScreenshot(checkboxSendItRightNow);}
    }
    public void sendByEmail() throws Exception {
        WebElement email=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[4]/div/div[1]/div[2]"));
        clickElement(email);
        //takeElementScreenshot(email);
        sendKeysToElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[4]/div/div[4]/div/div[1]/div/div/input"),"haha@gmail.com");
        WebElement submitButton=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[4]/div/div[4]/div/div[2]/button[2]"));
       // takeElementScreenshot(submitButton);
        clickElement(submitButton);
    }
    public void assertTest() {
        WebElement receiverName = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[2]/label[1]/input"));
        Assert.assertEquals(receiverName.getAttribute("value"), Constans.RECEIVER_NAME);
        WebElement senderName = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[2]/label[2]/input"));
        Assert.assertEquals(senderName.getAttribute("value"), Constans.SENDER);
    }

    //All below function belong to Event ComboBox
    public void chooseWeddingEvent() {

        //Wait until the element becomes visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[3]/label[1]/div")));


        WebElement selectAmountContainer = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[3]/label[1]/div"));
        selectAmountContainer.click();
        selectOption(5, "/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[3]/label[1]/div/div/ul");
        }
    /**
     * Select required fields
     */
    private void selectOption(int optionIndex, String xpath){

        //Wait until the dropdown becomes visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        //Click on the selected option
        WebElement dropdown = driver.findElement(By.xpath(xpath));
        List<WebElement> optionList=dropdown.findElements(By.tagName("li"));
        optionList.get(optionIndex).click();
    }
    /**
     * Click to expand the dropdown
     * @param dropdownId
     */
    private void clickOnDropDown(String dropdownId){

        //Wait until the element becomes visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id(dropdownId)));

        //Click on other element to expand it
        WebElement selectAmountContainer = driver.findElement(By.id(dropdownId));
        selectAmountContainer.click();
    }
}

