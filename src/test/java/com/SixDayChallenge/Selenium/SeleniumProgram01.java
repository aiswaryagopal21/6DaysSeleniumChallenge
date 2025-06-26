package com.SixDayChallenge.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumProgram01 {
    WebDriver driver;
    @BeforeTest
    public void LaunchBrowser(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }
    @Test
    public void loginPage(){
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("aiswaryagopal21@gmail.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123@ashu");
        WebElement login = driver.findElement(By.className("radius"));
        login.click();
        WebElement errorMessage = driver.findElement(By.id("flash"));
        String text = errorMessage.getText();
        System.out.println(text);
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
