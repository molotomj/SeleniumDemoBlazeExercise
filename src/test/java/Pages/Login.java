package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class   Login {

    WebDriver driver;

    // Locators
    By customerLoginButton = By.xpath("//button[contains(text(),'Customer Login')]");
    By customerDropdown = By.id("userSelect");
    By loginButton = By.xpath("//button[contains(text(),'Login')]");

    // Constructor
    public Login(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickCustomerLogin() {
        driver.findElement(customerLoginButton).click();
    }

    public void selectCustomer(String customerName) {
        WebElement dropdown = driver.findElement(customerDropdown);
        dropdown.click();
        dropdown.findElement(By.xpath("//option[contains(text(),'" + customerName + "')]")).click();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}

