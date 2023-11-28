package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * 1. userSholdLoginSuccessfullyWithValid
 * Credentials
 * Enter “standard_user” username
 * Enter “secret_sauce” password
 * Click on ‘LOGIN’ button
 * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * Enter “standard_user” username
 * Enter “secret_sauce” password
 * Click on ‘LOGIN’ button
 * Verify that six products are displayed
 * on pag
 */

public class LoginTest extends Utility {
    static String baseUrl = " https://www.saucedemo.com/";//baseUrl

    @Before
    public void setUp() {
        openBrowser(baseUrl);//Calling method from BaseTest class to open and set-up the browser
    }


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //Verify the text “PRODUCTS”
        String actual = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        String expected = "Products";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
        //Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //Verify that six products are displayed on page
        List<WebElement> items = driver.findElements(By.xpath("//div[@class = 'inventory_list']//div[@class = 'inventory_item']"));
        System.out.println("Total Products Displayed on Page : " + items.size());
    }


    @After
    public void TearDown() {
        closeBrowser();

    }

}
