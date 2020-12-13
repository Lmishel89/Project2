import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DriverSingleton {
    private static WebDriver driver;
    public static WebDriver getDriverInstance() throws Exception {
        String type = getData("browserType");
        if (type.equals("Chrome") && (driver == null)) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lena\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    private static String getData (String keyName) throws Exception{
        ClassLoader classLoader = DriverSingleton.class.getClassLoader();
        String xmlFilePath = String.valueOf(new File(classLoader.getResource("data.xml").getFile()));
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}
