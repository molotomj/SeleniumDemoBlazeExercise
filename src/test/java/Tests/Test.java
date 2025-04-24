package Tests;

public class Test extends Base {
    @org.testng.annotations.Test
    void Test1() {
        login.clickCustomerLogin();
        login.selectCustomer();
//        login.selectCustomer("Harry Potter");
//        login.zclickLogin();
    }
}
