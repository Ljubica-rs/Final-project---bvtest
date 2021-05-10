
package admin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.Logout;


public class LoginTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    //private static LoginPage loginPage;
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
        driver.manage().window().fullscreen();
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
    
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testValidlogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa@cubes.rs");
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("Bad URL redirection.", expectedUrl.equals(actualUrl));
        
        Logout logout = new Logout(driver);
        logout.clickOnNavDropDownButton();
        logout.clickOnLogoutButton();
        
        //WebElement navDropDownButton = driver.findElement(By.className("dropdown-toggle"));
       // navDropDownButton.click();
        
       // WebElement logoutButton = driver.findElement(By.linkText("Logout"));
       // logoutButton.click();
    }
    
    @Test
    public void testEmptyFieldsLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginButton();
    }
    
    @Test
    public void testInvalidEmailInvalidPasswordLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa8952@36cubes.rs");
        loginPage.enterPassword("qubezy68sqa");
        loginPage.clickOnLoginButton();
    }
    
    @Test
    public void testInvalidEmailValidPasswordLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qazygdk62@cubes.rs");
        loginPage.enterPassword("qubesqa");
        loginPage.clickOnLoginButton();
    }
    
    @Test
    public void testValidEmailInvalidPasswordLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa@cubes.rs");
        loginPage.enterPassword("qubyz568esqa");
        loginPage.clickOnLoginButton();
    }
}
