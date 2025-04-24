package Tests;

import Pages.Login;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "http://www.way2automation.com/angularjs-protractor/banking/#/login");
    Login login = PageFactory.initElements(driver, Login.class);
    //HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    // TakesScreenshots takesScreenshots = new TakesScreenshots();

    // ReadFromExcel readFromExcel;

//    {
//        try {
//            readFromExcel = new ReadFromExcel();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
