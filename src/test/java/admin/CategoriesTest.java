package admin;

import framework.Helper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.Logout;

/**
 *
 * @author Ljubica
 */
public class CategoriesTest {
    private static WebDriver driver;
    private static CategoriesPage categoriesPage;
    private static WebDriverWait wait;
    
    public CategoriesTest() {
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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa@cubes.rs");
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
        
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickOnCategoriesNavLink();
        
        categoriesPage = new CategoriesPage(driver);
    }
    
    @After
    public void tearDown() {
        //logout();
       Logout logout = new Logout(driver);
       logout.clickOnNavDropDownButton();
       logout.clickOnLogoutButton();
    }
    
   // private void login() {
     //   WebElement emailField = driver.findElement(By.name("email"));
     //   emailField.sendKeys("qa@cubes.rs");
        
      //  WebElement passwordField = driver.findElement(By.name("password"));
      //  passwordField.sendKeys("cubesqa");
        
      //  WebElement loginButton = driver.findElement(By.className("btn-primary"));
      //  loginButton.click(); 
  //  }
    
   // private void logout() {
      //  WebElement navDropDownButton = driver.findElement(By.className("dropdown-toggle"));
      //  navDropDownButton.click();
        
      //  WebElement logoutButton = driver.findElement(By.linkText("Logout"));
     //   logoutButton.click();
    //}
    
    @Test
    public void testElementsPresent() {
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
        
        String expectedPanelTitle = "Categories";
        String actualPanelTitle = categoriesPage.getPanelHeadingText();
        assertTrue("Panel title is bad.", actualPanelTitle.startsWith(expectedPanelTitle));
        
        //System.out.println("driver.findElement(By.className(\"panel-heading\")).getText()");
    }
    
    @Test
    public void testAddNewCategory() {
        
        //WebElement navCategory = driver.findElement(By.linkText("Categories"));
        //navCategory.click();
        
        //create new category
        //precondition: User is logged in and on page for Categories
        //1. Click on button "Add Category"
        //2. enter unique title in Title field
        //3. click on Save button
        //expected result >
        // - user is redirected to categories page 
        // - confirmation message is shown: "Category "title" has been successfully saved"
        // - new category is liste as the last element in table 
         
        //WebElement addNewCategoryButton = driver.findElement(By.className("pull-right"));
        //addNewCategoryButton.click();
        
        categoriesPage.clickOnAddNewCategoryButton(); 
        categoriesPage.inputTitleText();
        String newCategoryTitle = categoriesPage.getTitleText();
        categoriesPage.clickOnSaveButton();
        
        //WebElement titleField = driver.findElement(By.id("title"));
       // String newCategoryTitle = Helper.generateTitle();
       // titleField.sendKeys(newCategoryTitle);
        
       // WebElement saveButton = driver.findElement(By.id("save-category-button"));
       // saveButton.click();
        
        String expectedAlertMessage = "Category \"" + newCategoryTitle + "\" has been successfully saved!";
        String actualAlertMessage = categoriesPage.getActualAlertMessage();
        assertTrue("Alert message is not correct.", expectedAlertMessage.equals(actualAlertMessage));
        
        //String actualAlertMessage = driver.findElement(By.className("alert-success")).getText();
        
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
    }
    
    @Test
    public void testCancelAddingNewCategory() {
        
        //WebElement navCategory = driver.findElement(By.linkText("Categories"));
        //navCategory.click();
  
       // WebElement addNewCategoryButton = driver.findElement(By.className("pull-right"));
        //addNewCategoryButton.click();
        categoriesPage.clickOnAddNewCategoryButton();
        categoriesPage.inputTitleText();
        categoriesPage.clickOnBackToCategoriesButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("URLs do not match.", expectedUrl.equals(actualUrl));
    }
}

