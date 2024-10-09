package com.WDB2.Selenium_Task_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAutomation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://jqueryui.com/droppable/");

            Thread.sleep(2000);

            WebElement iframe = driver.findElement(By.className("demo-frame"));
            driver.switchTo().frame(iframe);

            Thread.sleep(2000);

            WebElement source = driver.findElement(By.id("draggable"));
            WebElement target = driver.findElement(By.id("droppable"));

            Thread.sleep(2000);

            Actions action = new Actions(driver);
            action.dragAndDrop(source, target).perform();

            Thread.sleep(1000);

            String droppedText = target.getText();
            String textColor = target.getCssValue("color");

            Thread.sleep(2000);

            if ("Dropped!".equals(droppedText) && textColor.equals("rgba(119, 118, 32, 1)")) { 
                System.out.println("Drag and Drop Successful!");
            } else {
                System.out.println("Drag and Drop Failed!");
                System.out.println("Dropped Text: " + droppedText);
                System.out.println("Text Color: " + textColor);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
       }
        finally {
            driver.quit();
         }
    }
}
