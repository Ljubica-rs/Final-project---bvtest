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
import pages.PortalsPage;


public class PortalsTest {
    private static WebDriver driver;
    private static PortalsPage portalsPage; 
    
    public PortalsTest() {
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
        dashboardPage.clickOnPortalsNavLink();
        
        portalsPage = new PortalsPage(driver);
    }
    
    @After
    public void tearDown() {
        Logout logout = new Logout(driver);
        logout.clickOnNavDropDownButton();
        logout.clickOnLogoutButton();
    }


    @Test
    public void testElementsPresent() {
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
        
        String expectedPanelTitle = "Portals";
        String actualPanelTitle = portalsPage.getPanelHeadingText();
        assertTrue("Panel title is bad.", actualPanelTitle.startsWith(expectedPanelTitle));
    }
    
    @Test
    public void testCancelAddingNewPortal() {
        portalsPage.clickOnAddNewPortalsButton();
        portalsPage.inputTitleText();
        portalsPage.clickOnBackToPortalsButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
    
        String expectedPanelTitle = "Portals";
        String actualPanelTitle = portalsPage.getPanelHeadingText();
        assertTrue("Panel title is bad.", actualPanelTitle.startsWith(expectedPanelTitle));
    }
    
    @Test
    public void testDeleteFirstPortal() {
        String titleFirstPortal = portalsPage.getTitleForFirstPortal();
        System.out.println(titleFirstPortal);
        
        portalsPage.clickOnDeleteButtonForFirstPortal();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        portalsPage.clickOnConfirmDeleteButtonForFirstPortal();
        
        String titleFirstPortalAfterDelete = portalsPage.getTitleForFirstPortal();
        System.out.println(titleFirstPortalAfterDelete);
        
        String expectedAlertMessage = "Portal \"" + titleFirstPortal + "\" has been successfully deleted!"; 
        String actualAlertMessage = portalsPage.getActualAlertMessage();
        assertTrue("Alert message is not correct.", expectedAlertMessage.equals(actualAlertMessage));
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
    }
    
    @Test
    public void testAddOnlyNewPortalTitle() {
        portalsPage.clickOnAddNewPortalsButton();
        portalsPage.inputTitleText();
        portalsPage.clickOnSaveButton();

        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals/insert";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
        
        String expectedPanelTitle = "Portals | Insert Portal";
        String actualPanelTitle = portalsPage.getPanelHeadingText();
        assertTrue("Panel title is bad.", actualPanelTitle.startsWith(expectedPanelTitle));
    }

    @Test
    public void testAddNewPortalTitleWithUrlAndRegion() {
        portalsPage.clickOnAddNewPortalsButton();
        portalsPage.inputTitleText();
        portalsPage.enterUrl("http://portal.net");
        portalsPage.clickOnSelectRegion();
        portalsPage.clickOnSaveButton();
        
        String newPortalTitle = portalsPage.getTitleText();
        String expectedAlertMessage = "Portal \"" + newPortalTitle + "\" has been successfully saved!";
        String actualAlertMessage = portalsPage.getActualAlertMessage();
        assertTrue("Alert message is not correct.", expectedAlertMessage.equals(actualAlertMessage));
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
    }
}

