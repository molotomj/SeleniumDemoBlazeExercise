package Pages;

import Tests.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class Login {

    WebDriver driver;

    // Locators
    By customerLoginButton = By.xpath("//button[normalize-space()='Customer Login']");
    By customerDropdown = By.id("userSelect");
    By loginButton = By.xpath("//button[contains(text(),'Login')]");

    // Constructor
    public Login(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickCustomerLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerLoginButton));
        WebElement clickTheBtn = driver.findElement(customerLoginButton);
        clickTheBtn.click();

    }

    public void selectCustomer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerDropdown));
        WebElement custDropDown = driver.findElement(customerDropdown);
        Select select = new Select(custDropDown);
        select.selectByIndex(1);
        custDropDown.click();
        custDropDown.sendKeys(Keys.ENTER);

      //  dropdown.findElement(By.xpath("//option[contains(text(),'" + customerName + "')]")).click();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}

