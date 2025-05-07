package Tests;

import Pages.Account;
import Pages.Login;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory;
    WebDriver driver;
    Login login;
    Account account;

    public void initializeDriver() {
        browserFactory = new BrowserFactory();
        driver = browserFactory.startBrowser("chrome", "http://www.way2automation.com/angularjs-protractor/banking/#/login");
        login = PageFactory.initElements(driver, Login.class);
        account = PageFactory.initElements(driver, Account.class);
    }
}
