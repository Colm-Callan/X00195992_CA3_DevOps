package com.example.calculator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assumptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorSeleniumRunningAppTest {

    static WebDriver driver;

    @BeforeAll
    static void setupClass() {
        try {
            WebDriverManager.chromedriver().setup();
        } catch (RuntimeException e) {
            Assumptions.assumeTrue(false, "Chromedriver setup failed: " + e.getMessage());
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @AfterAll
    static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void uatAdditionAgainstRunningApp() {
        // Target the running bootRun server on port 8080
        String url = "http://localhost:8080/";
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("a")));

        driver.findElement(By.id("a")).sendKeys("4");
        driver.findElement(By.id("op")).sendKeys("+");
        driver.findElement(By.id("b")).sendKeys("5");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("result")));
        String resultText = driver.findElement(By.id("result")).getText();
        Assertions.assertTrue(resultText.contains("9"), "Expected result to contain 9 but was: " + resultText);
    }
}