package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Account {
    WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[3]/button[1]")
    WebElement transactionButton;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[3]/button[2]")
    WebElement depositButton;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[3]/button[3]")
    WebElement withdrawButton;
    @FindBy(id = "accountSelect")
    WebElement accountSelect;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[4]/div/form/div/input")
    WebElement amountInput;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[4]/div/form/button")
    WebElement depositButton_xpath;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[4]/div/span")
    WebElement transactionMessage_xpath;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/button[2]")
    WebElement logoutButton_xpath;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/button[1]")
    WebElement homeButton_xpath;

    public void selectAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(accountSelect));
        Select select = new Select(accountSelect);
        select.selectByIndex(0); //Select first account
        accountSelect.click();
        accountSelect.sendKeys(Keys.ENTER);
    }

    public void depositMoney(String depositAmount) {
        depositButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(amountInput));
        amountInput.sendKeys(depositAmount);
        depositButton_xpath.click();
    }

    public void VerifySuccessfulDeposit() {
        transactionButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(transactionMessage_xpath));
        boolean isMessageDisplayed = transactionMessage_xpath.isDisplayed();
        if (isMessageDisplayed) {
            System.out.println("Success is displayed.");
            assert true;
        } else {
            System.out.println("Success message is not displayed.");
            Assert.fail();
            assert false;
        }


    }

    public void customerLogout() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(logoutButton_xpath));
        logoutButton_xpath.click();
        homeButton_xpath.click();
    }

    public void depositToEachAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(accountSelect));
        Select select = new Select(accountSelect);

        // Get all available accounts
        List<WebElement> accounts = select.getOptions();

        for (int i = 0; i < accounts.size(); i++) {
            // Select each account by index
            select.selectByIndex(i);
            accountSelect.click();
            accountSelect.sendKeys(Keys.ENTER);

            // Perform deposit operation
            depositButton.click();
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(amountInput));
            amountInput.clear();
            amountInput.sendKeys("1500");
            depositButton_xpath.click();

            // Verify deposit success
            //transactionButton.click();
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(transactionMessage_xpath));
            boolean isMessageDisplayed = transactionMessage_xpath.isDisplayed();
            if (isMessageDisplayed) {
                System.out.println("Deposit successful for account: " + accounts.get(i).getText());
            } else {
                System.out.println("Deposit failed for account: " + accounts.get(i).getText());
            }
        }
    }

public void withdrawMoney(String withdrawAmount) {


    // Withdraw money
    withdrawButton.click();
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(amountInput));
    amountInput.clear();
    amountInput.sendKeys(withdrawAmount);
    depositButton_xpath.click(); // Assuming the same button is used for withdrawal

    // Verify withdrawal success
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(transactionMessage_xpath));
    boolean isWithdrawMessageDisplayed = transactionMessage_xpath.isDisplayed();
    if (isWithdrawMessageDisplayed) {
        System.out.println("Withdrawal of " + withdrawAmount + " was successful.");
    } else {
        System.out.println("Withdrawal of " + withdrawAmount + " failed.");
        Assert.fail();
    }
}


}
