package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NovoTeste {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    String localChromeDriver = "WebContent/assets/chromedriver.exe";
    System.setProperty("webdriver.chrome.driver", localChromeDriver);
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testNovoTeste() throws Exception {
    driver.get("http://localhost:8080/ConversorCelsiusFahrenheit/index.jsp");
    driver.findElement(By.xpath("(//input[@name='tipo'])[2]")).click();
    driver.findElement(By.name("valor")).click();
    driver.findElement(By.name("valor")).clear();
    driver.findElement(By.name("valor")).sendKeys("100");
    driver.findElement(By.name("calc")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Realize Outra Conversão'])[1]/preceding::h1[1]")).click();
    assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Realize Outra Conversão'])[1]/preceding::h1[1]")).getText(), "O resultado da conversão de Celsius para Fahrenheit é: 212");
    driver.findElement(By.xpath("//*/text()[normalize-space(.)='Realize Outra Conversão']/parent::*")).click();
    driver.findElement(By.name("tipo")).click();
    driver.findElement(By.name("valor")).click();
    driver.findElement(By.name("valor")).clear();
    driver.findElement(By.name("valor")).sendKeys("212");
    driver.findElement(By.name("calc")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Realize Outra Conversão'])[1]/preceding::h1[1]")).click();
    assertEquals(driver.getTitle(), "Resultado da soma");
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
