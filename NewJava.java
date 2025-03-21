package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewJava {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        driver.get("https://accounts.google.com/");

        // Enter username (email)
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
        username.sendKeys("2200039004cser@gmail.com");
        Thread.sleep(700);

        // Click the "Next" button
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[span[text()='Next']]")));
        nextButton.click();
        Thread.sleep(1000);

        WebElement tryAgainLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Try again']")));
        tryAgainLink.click();
        Thread.sleep(1000);

        WebElement username1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
        username1.sendKeys("2200039004cser@gmail.com");
        Thread.sleep(700);

        // Click the "Next" button
        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[span[text()='Next']]")));
        nextButton1.click();
        Thread.sleep(1000);
    }




//        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
//        password.sendKeys("9693311421@Om");
//        Thread.sleep(700);
//
//        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginbtn")));
//        highlight(driver, loginButton);
//        Thread.sleep(700)
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

