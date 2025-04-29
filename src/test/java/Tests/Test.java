package Tests;

public class Test extends Base {
    @org.testng.annotations.Test
    void Test1() {
        login.clickCustomerLogin();
        login.selectCustomer(1);
        account.selectAccount();
        account.depositMoney();
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
}
