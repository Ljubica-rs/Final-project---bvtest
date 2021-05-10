package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver driver;
    private By dashboardLinkLocator = By.linkText("Dashboard");
    private By categoriesLinkLocator = By.linkText("Categories");
    private By regionsLinkLocator = By.linkText("Regions");
    private By portalsLinkLocator = By.linkText("Portals");
    private By signaturesLinkLocator = By.linkText("Signatures");
    private By sourcesLinkLocator = By.linkText("Sources");
    private By panelHeadingLocator = By.className("panel-heading");
    private By addNewSourceButtonLocator = By.className("pull-right");
   
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOnDashboardNavLink() {
        driver.findElement(dashboardLinkLocator).click();
    }
 
    public void clickOnCategoriesNavLink() {
        driver.findElement(categoriesLinkLocator).click();
    }
   
    public void clickOnRegionsNavLink() {
        driver.findElement(regionsLinkLocator).click();
    }
   
    public void clickOnPortalsNavLink() {
        driver.findElement(portalsLinkLocator).click();
    }
   
    public void clickOnSignaturesNavlink() {
        driver.findElement(signaturesLinkLocator).click();
    }
    
    public void clickOnSourcesNavLink() {
        driver.findElement(sourcesLinkLocator).click();
    }
    
    public String getPanelHeadingText(){
        return driver.findElement(panelHeadingLocator).getText();
    }
    
    public String getButtonNameFromPanel(){
        return driver.findElement(addNewSourceButtonLocator).getText();
    }
    
}
