package admin;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.Logout;
import pages.RegionsPage;

public class RegionsTest {
    private static WebDriver driver;
    private static RegionsPage regionsPage;

    public RegionsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa@cubes.rs");
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton(); 
        
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickOnRegionsNavLink();
        
        regionsPage = new RegionsPage(driver);
    }

    @After
    public void tearDown() {
        Logout logout = new Logout(driver);
        logout.clickOnNavDropDownButton();
        logout.clickOnLogoutButton();
    }

    @Test
    public void testElementsPresent() {
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
        
        String expectedPanelTitle = "Regions";
        String actualPanelTitle = regionsPage.getPanelHeadingText();
        assertTrue("Panel title is bad.", actualPanelTitle.startsWith(expectedPanelTitle));
    }

    @Test
    public void testAddNewRegion() {
        regionsPage.clickOnAddNewRegionsButton();
        regionsPage.inputTitleText();
        String newRegionTitle = regionsPage.getTitleText();
        regionsPage.clickOnSaveButton();
        
        //WebElement titleField = driver.findElement(By.id("title"));
        //String newRegionTitle = Helper.generateTitle();
        //titleField.sendKeys(newRegionTitle);

        String expectedAlertMessage = "Region \"" + newRegionTitle + "\" has been successfully saved!";
        String actualAlertMessage = regionsPage.getActualAlertMessage();
        assertTrue("Alert message is not correct.", expectedAlertMessage.equals(actualAlertMessage));
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
    }

    @Test
    public void testCancelAddingNewRegion() {
        regionsPage.clickOnAddNewRegionsButton();
        regionsPage.inputTitleText();
        regionsPage.clickOnBackToRegionsButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
        
        String expectedPanelTitle = "Regions";
        String actualPanelTitle = regionsPage.getPanelHeadingText();
        assertTrue("Panel title is bad.", actualPanelTitle.startsWith(expectedPanelTitle));
    }

    @Test
    public void testDeleteFirstRegion() {
        String titleFirstRegion = regionsPage.getTitleForFirstRegion();
        System.out.println(titleFirstRegion);
        
        regionsPage.clickOnDeleteButtonForFirstRegion();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        regionsPage.clickOnConfirmDeleteButtonForFirstRegion();
        
        String titleFirstRegionAfterDelete = regionsPage.getTitleForFirstRegion();
        System.out.println(titleFirstRegionAfterDelete);
        
        String expectedAlertMessage = "Region \"" + titleFirstRegion + "\" has been successfully deleted!";  
        String actualAlertMessage = regionsPage.getActualAlertMessage();
        assertTrue("Alert message is not correct.", expectedAlertMessage.equals(actualAlertMessage));
                
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
        
    }

    @Test
    public void testDisableFirstRegion() {
       if (("D").equals(regionsPage.statusOfFirstTitle())){
            regionsPage.clickOnEnableButtonForFirstRegion();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            regionsPage.clickOnConfirmEnableButtonForFirstRegion();
        }
        
        String titleFirstRegion = regionsPage.getTitleForFirstRegion();
        regionsPage.clickOnDisableButtonForFirstRegion();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        regionsPage.clickOnConfirmDisableButtonForFirstRegion();
        
        String expectedAlertMessage = "Region \"" + titleFirstRegion + "\" has been disabled";
        String actualAlertMessage = regionsPage.getActualAlertMessage();
        assertTrue("Alert message is not correct.", expectedAlertMessage.equals(actualAlertMessage));
    }

    @Test
    public void testEnableFirstRegion() {
        if (("E").equals(regionsPage.statusOfFirstTitle())){
            regionsPage.clickOnDisableButtonForFirstRegion();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            regionsPage.clickOnConfirmDisableButtonForFirstRegion();
        } 
        
        String titleFirstRegion = regionsPage.getTitleForFirstRegion();
        regionsPage.clickOnEnableButtonForFirstRegion();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        regionsPage.clickOnConfirmEnableButtonForFirstRegion();
        
        String expectedAlertMessage = "Region \"" + titleFirstRegion + "\" has been enabled";
        String actualAlertMessage = regionsPage.getActualAlertMessage();
        assertTrue("Alert message is not correct.", expectedAlertMessage.equals(actualAlertMessage));
    }
    
    @Test
    public void testEditThirdRegion(){
        String titleForThirdRegion = regionsPage.getTitleForThirdRegion();
        System.out.println(titleForThirdRegion);
        
        regionsPage.clickOnEditButtonForThirdRegion();
        regionsPage.clearTitleField();
        regionsPage.inputTitleText();
        regionsPage.clickOnSaveButton();
        String newTitleForThirdRegion = regionsPage.getTitleForThirdRegion();
        System.out.println(newTitleForThirdRegion);
        
        String expectedAlertMessage = "Region \"" + newTitleForThirdRegion + "\" has been successfully saved!";
        String actualAlertMessage = regionsPage.getActualAlertMessage();
        assertTrue("Alert message is not correct.", expectedAlertMessage.equals(actualAlertMessage));
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
    }
    
    @Test
    public void testCategoriesLinkRedirect() {
        regionsPage.clickOnCategoriesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
        
        String expectedPanelTitle = "Categories";
        String actualPanelTitle = regionsPage.getPanelHeadingText();
        assertTrue("Panel title is bad.", actualPanelTitle.startsWith(expectedPanelTitle));
    }
    
}
