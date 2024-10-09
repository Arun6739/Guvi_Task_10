package com.WDB2.Selenium_Task_10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerAutomation {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://jqueryui.com/datepicker/");
            
            Thread.sleep(2000);

            WebElement iframe = driver.findElement(By.className("demo-frame"));
            driver.switchTo().frame(iframe);
            
            Thread.sleep(2000);

            WebElement datePicker = driver.findElement(By.id("datepicker"));
            datePicker.click();
            
            Thread.sleep(2000);

            WebElement nextButton = driver.findElement(By.className("ui-datepicker-next"));
            nextButton.click();
            
            Thread.sleep(2000);

            WebElement dateToSelect = driver.findElement(By.xpath("//a[text()='22']"));
            dateToSelect.click();

            Thread.sleep(2000);

            String selectedDate = datePicker.getAttribute("value");
            System.out.println("Selected Date: " + selectedDate);
            
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
