package Tests;

public class Test extends Base {
    @org.testng.annotations.Test
    void Test1() {
        login.clickCustomerLogin();
        login.selectCustomer();
        account.selectAccount();
        account.depositMoney();
        account.VerifySuccessfulDeposit();
        account.customerLogout();

    }
}
