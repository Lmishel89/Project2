import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SearchScreen extends BasePage  {
    private WebDriver driver;

    public SearchScreen(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Select all required fields
     */
     public void selectAllOptions() {

        //Select desired amount
        clickOnDropDown("ember780_chosen");
        selectOption(2, "/html/body/div[1]/div/header/div[3]/div/form/div[1]/div/ul");

        //Select area
        clickOnDropDown("ember795_chosen");
        selectOption(2, "/html/body/div[1]/div/header/div[3]/div/form/div[2]/div/ul");

        //Select category
        clickOnDropDown("ember805_chosen");
        selectOption(2, "/html/body/div[1]/div/header/div[3]/div/form/div[3]/div/ul");
    }
    /**
     * Select an option from dropdown list
     * @param optionIndex
     * @param xpath
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

    public void clickElement() {
        WebElement findMeGift = driver.findElement(By.id("ember840"));
        findMeGift.click();
    }
    public void assertTest(){
        String url= driver.getCurrentUrl();
        Assert.assertEquals(url,"https://buyme.co.il/");}
}




