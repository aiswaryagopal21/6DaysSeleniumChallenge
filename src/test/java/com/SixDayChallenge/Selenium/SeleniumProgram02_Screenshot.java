package com.SixDayChallenge.Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SeleniumProgram02_Screenshot {
    WebDriver driver;
    @BeforeTest
    public void launchBrowser() {
         driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void searchForIt() throws IOException {
        TakesScreenshot fs = (TakesScreenshot) driver;
        File srcFile = fs.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss").format(new Date());
        FileUtils.copyFile(srcFile, new File("Screenshots\\IMG"+timeStamp+".png"));
        WebElement continueButton = driver.findElement(By.className("a-button-text"));
        continueButton.click();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Amazon.com. Spend less. Smile more.");
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
