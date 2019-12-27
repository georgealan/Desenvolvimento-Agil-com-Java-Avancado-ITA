import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PaginaSomaTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        String localChromeDriver = "assets/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", localChromeDriver);
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("http://localhost:8080/SomarParcelas/index.jsp");
        driver.findElement(By.name("p1")).click();
        driver.findElement(By.name("p1")).clear();
        driver.findElement(By.name("p1")).sendKeys("12");
        driver.findElement(By.name("p2")).click();
        driver.findElement(By.name("p2")).clear();
        driver.findElement(By.name("p2")).sendKeys("21");
        driver.findElement(By.name("calcular")).click();
        //driver.findElement(By.xpath("//html")).click();
        assertEquals(driver.findElement(By.xpath("//*/text()[normalize-space(.)='O resultado foi 33']/parent::*")).getText(), "O resultado foi 33");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
