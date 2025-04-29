package Tests;

public class Test extends Base {
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