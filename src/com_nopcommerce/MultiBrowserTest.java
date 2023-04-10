package com_nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {

    // default browser open
    static String browser = "Edge";
    static String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%252";

    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name please Select Other");
        }

        //maximize browser size
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //we give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Get the Current url
        System.out.println("Current Url: " + driver.getCurrentUrl());

        //Get page Source
        System.out.println("Page Source: " +driver.getPageSource());

        //Find the Login Link element
        WebElement logLink = driver.findElement(By.linkText("Log in"));

        //click on login link element
        logLink.click();

        //find the Email Field Element
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("Viral123@gmail.com");

        //find the Password Field and Type the Password
        driver.findElement(By.name("Password")).sendKeys("Viral123");

        //Close the Browser
        driver.close();
    }
}
