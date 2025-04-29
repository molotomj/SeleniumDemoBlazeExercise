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

    public void selectCustomer(int custIndex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerDropdown));
        WebElement custDropDown = driver.findElement(customerDropdown);
        Select select = new Select(custDropDown);
        select.selectByIndex(custIndex);
        custDropDown.click();
        custDropDown.sendKeys(Keys.ENTER);
        WebElement loginBtn = driver.findElement((loginButton));
        loginBtn.click();

    }


    public void zclickLogin() {
        driver.findElement(loginButton).click();
    }
}

