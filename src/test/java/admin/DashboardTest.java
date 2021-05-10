package admin;

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

public class DashboardTest {
    private static WebDriver driver;
    private static DashboardPage dashboardPage;
    
    public DashboardTest() {
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
        dashboardPage = new DashboardPage(driver);
    }
    
    @After
    public void tearDown() {
        Logout logout = new Logout(driver);
        logout.clickOnNavDropDownButton();
        logout.clickOnLogoutButton();
    }

     @Test
     public void testDashboardLinkRedirect() {
        dashboardPage.clickOnDashboardNavLink();
         
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
        
        String expectedPanelTitle = "Dashboard";
        String actualPanelTitle = dashboardPage.getPanelHeadingText();
        assertTrue("Panel title is Sbad.", actualPanelTitle.startsWith(expectedPanelTitle));
     }
     
     @Test
     public void testSignaturesLinkRedirect() {
        dashboardPage.clickOnSignaturesNavlink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
        
        String expectedPanelTitle = "Signatures";
        String actualPanelTitle = dashboardPage.getPanelHeadingText();
        assertTrue("Panel title is Sbad.", actualPanelTitle.startsWith(expectedPanelTitle));
     }
     
     @Test
     public void testSourcesLinkRedirect() {
        dashboardPage.clickOnSourcesNavLink();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
        
        String expectedPanelButtonTitle = "Add source";
        String actualPanelButtonTitle = dashboardPage.getButtonNameFromPanel();
        assertTrue("Panel title is Sbad.", actualPanelButtonTitle.startsWith(expectedPanelButtonTitle));
     }
     
     @Test
     public void testCategoriesLinkRedirect() {
        dashboardPage.clickOnCategoriesNavLink();
         
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
        
        String expectedPanelTitle = "Categories";
        String actualPanelTitle = dashboardPage.getPanelHeadingText();
        assertTrue("Panel title is bad.", actualPanelTitle.startsWith(expectedPanelTitle));
     }
     
     @Test
     public void testRegionsLinkRedirect() {
        dashboardPage.clickOnRegionsNavLink();
         
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
        
        String expectedPanelTitle = "Regions";
        String actualPanelTitle = dashboardPage.getPanelHeadingText();
        assertTrue("Panel title is bad.", actualPanelTitle.startsWith(expectedPanelTitle));
     }
     
     @Test
     public void testPortalsLinkRedirect() {
        dashboardPage.clickOnPortalsNavLink();
         
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
        
        String expectedPanelTitle = "Portals";
        String actualPanelTitle = dashboardPage.getPanelHeadingText();
        assertTrue("Panel title is bad.", actualPanelTitle.startsWith(expectedPanelTitle));
     }
}
