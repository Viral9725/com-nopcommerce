package com_nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTest {

    public static void main(String[] args)
    {
        String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%252";

        //Launch the Chrome Browser
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        //maximise the Browser
        driver.manage().window().maximize();

        //we give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Get the Title of the Page
        String title = driver.getTitle();
        System.out.println(title);

        //Get the Current Url
        System.out.println("Current url: " +driver.getCurrentUrl());

        // Get Page Source
        System.out.println("Page Source" +driver.getPageSource());

        //Find the Login Link element
        WebElement loginLink = driver.findElement(By.linkText("Log in"));

        //click on login link Element
        loginLink.click();

        //find the Email Element
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("Viral123@gmail.com");

        //find the Password Field Element and Type the Password
        driver.findElement(By.name("Password")).sendKeys("Viral123");

        //click on login element
        loginLink.click();

        //Close the Browser
        driver.close();
    }
}
