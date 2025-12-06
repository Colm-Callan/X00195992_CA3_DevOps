package com.example.calculator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Duration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorSeleniumTest {

    static WebDriver driver;

    @LocalServerPort
    int port;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @AfterAll
    static void teardown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void uatAddition() {
        String url = "http://localhost:" + port + "/";
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("a")));

        driver.findElement(By.id("a")).sendKeys("4");
        driver.findElement(By.id("op")).sendKeys("+");
        driver.findElement(By.id("b")).sendKeys("5");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        // wait for result text to appear
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("result"), "Result"));

        String resultText = driver.findElement(By.id("result")).getText();
        Assertions.assertTrue(resultText.contains("9"), "Expected result to contain 9 but was: " + resultText);
    }
}