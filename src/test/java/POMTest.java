import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class POMTest extends BasePage {

    private static ExtentReports extent=new ExtentReports();
    private static ExtentTest test=extent.createTest("MyFirstTest","Sample description");
    private static WebDriverWait wait;

    @BeforeClass
    public static void runOnceBeforeClass() throws Exception {
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter= new ExtentSparkReporter(cwd + "/extent.html");
        extent.attachReporter(htmlReporter);
        driver=DriverSingleton.getDriverInstance();
        driver.get("https://buyme.co.il" );
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Welcome/First Screen(Input User Credentials details)
    @Test
    public void test01() throws Exception {

        LoginPage login = new LoginPage(driver);
        login.main_Page();
        login.enterCredentials();
        String timeNow = String.valueOf(System.currentTimeMillis());
        test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
    }

    //Assert all Details from SighIn Form
    @Test
    public void test02(){
        LoginPage login = new LoginPage(driver);
        login.assertTest();
    }

   // Email Validation
    @Test
    public void test03(){
        LoginPage.validateEmail(Constans.EMAIL);
    }

    //Click on Button from SighIn Form
    @Test
    public void test04(){
        LoginPage login = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        login.clickElement();
        String timeNow = String.valueOf(System.currentTimeMillis());
        test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());

    }

    //Define Details using DropDownList and Button
    @Test
    public void test05(){
        SearchScreen searchScreen = new SearchScreen(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        searchScreen.selectAllOptions();
        searchScreen.clickElement();
        searchScreen.assertTest();
        String timeNow = String.valueOf(System.currentTimeMillis());
        test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
    }

    //Choosing Relevant Chief/Restaurant and Input amount
    @Test
    public void test06() throws Exception {
        ResultsPage page = new ResultsPage(driver);
        page.clickElement();
        page.chooseAmount();
        String timeNow = String.valueOf(System.currentTimeMillis());
        test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        page.chooseChief();
    }

    // To Send To Screen
    @Test
    public void test07() throws Exception {
        GiftCardPage gift =new GiftCardPage(driver);
        gift.clickElement();
        gift.receiverAndSenderName();
        gift.chooseWeddingEvent();
        gift.blessingMessage();
        gift.insertScreenShot();
        gift.whenToSend();
        gift.sendByEmail();
        gift.assertTest();
        String timeNow = String.valueOf(System.currentTimeMillis());
        test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
    }

    @AfterClass
    public static void tearDown() {
        extent.flush();
        driver.quit();
    }
}
