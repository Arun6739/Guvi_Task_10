package com.WDB2.Selenium_Task_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GuviSignup {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.guvi.in/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            WebElement signupBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/register/' and text()='Sign up']")));
            signupBtn.click();

            Thread.sleep(3000);

            WebElement nameField = driver.findElement(By.id("name"));
            nameField.sendKeys("Arun");
            Thread.sleep(3000);
             
            WebElement emailField = driver.findElement(By.id("email"));
            //change the numeric in email for next test other wise it will stuck with signup page
            emailField.sendKeys("Arun321@example.com");
            Thread.sleep(3000);

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("Arun123");
            Thread.sleep(3000);

            WebElement mobileField = driver.findElement(By.id("mobileNumber"));
            mobileField.sendKeys("1234567890");
            Thread.sleep(3000);

            WebElement signupSubmit = driver.findElement(By.cssSelector("a#signup-btn"));
            signupSubmit.click();

            Thread.sleep(2000);

            WebElement submit =driver.findElement(By.cssSelector("a#laterBtn"));
            submit.click();
            
            Thread.sleep(2000);
           
            if (driver.getTitle().contains("GUVI | Sign")) {
                System.out.println("Considering it has a Successful Registration!");
                driver.navigate().refresh();

            }

            Thread.sleep(2000);

            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login']")));
            loginBtn.click();

            Thread.sleep(2000);

            WebElement loginEmail = driver.findElement(By.id("email"));
            //change the numeric in email for next test 

            loginEmail.sendKeys("Arun321@example.com");
            Thread.sleep(3000);

            WebElement loginPassword = driver.findElement(By.id("password"));
            loginPassword.sendKeys("Arun123");
            Thread.sleep(3000);

            WebElement loginSubmit = driver.findElement(By.cssSelector("a#login-btn"));
            loginSubmit.click();
            Thread.sleep(3000);

            Thread.sleep(3000); 
            if (driver.getTitle().contains("Dashboard")) {
                System.out.println("Login Successful!");
            }
            
            else {
            	System.out.println("Unsuccessful login!!!");
            	/*Somtimes a popup is generating instead of this incorrect password 
            	String res=driver.findElement(By.className("invalid-feedback")).getText();
            	System.out.println(res);*/
                System.out.println("WITH CORRECT LOGIN CREDENTIALS YOU CAN LOGIN");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
           driver.quit();
        }
        }
    }


    
   
