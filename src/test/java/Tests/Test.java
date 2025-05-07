package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Test extends Base {
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            initializeDriver(); // Ensure WebDriver is initialized
        }
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Quit WebDriver after each test
            driver = null; // Reset driver to avoid reuse of invalid session
        }
    }
    @org.testng.annotations.Test
    void Test1() {
        login.clickCustomerLogin();
        login.selectCustomer(1);
        account.selectAccount();
        account.depositMoney("1500");
        account.VerifySuccessfulDeposit();
        account.customerLogout();

    }

    @org.testng.annotations.Test
    void Test2() {
        login.clickCustomerLogin();
        login.selectCustomer(2);
        account.depositToEachAccount();
        account.customerLogout();
    }
    @org.testng.annotations.Test
    void Test3() {
        login.clickCustomerLogin();
        login.selectCustomer(3);
        account.selectAccount();
        account.depositMoney("31459");
        account.VerifySuccessfulDeposit();

    }

}