package Bhinneka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
    WebDriver driver;

    @BeforeTest
    private void init() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/macbook/Downloads/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();

        driver.navigate().to("https://bhinneka.com");
        driver.manage().window().maximize();
    }

    @Test (priority = 0)
    private void CheckElement() {
        //check element
        driver.findElement(By.className("bmd-login-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div h1")).getText(), "Silakan login ke akun Anda");
        Assert.assertEquals(driver.findElement(By.className("css-zcqpx8")).getText(), "atau login dengan");
        Assert.assertEquals(driver.findElement(By.className("css-1tgpxow")).getText(), "Belum punya akun Bhinneka? Register");
    }

    @Test (priority = 1)
    private void CheckButton(){
        //check button
        driver.findElement(By.className("css-e50tt9"));
        driver.findElement(By.className("css-7pzexw"));
        driver.findElement(By.className("css-7pzexw"));
    }

    @Test (priority = 2)
    private void EmptyEmail(){
        //Empty Email
        driver.findElement(By.id("input")).sendKeys("repo");
        Assert.assertEquals(driver.findElement(By.className("css-1eoh06y")).getText(), "Wrong email format");

    }

    @AfterTest
    public void closeBrowser() { driver.quit();}

}