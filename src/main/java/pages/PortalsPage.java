package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PortalsPage {
    private WebDriver driver;
    private By panelHeadingLocator = By.className("panel-heading");
    private By addNewPortalsButtonLocator = By.className("pull-right");
    private By titleFieldLocator = By.id("title");
    private String newPortalTitle = Helper.generateTitle2();
    private By saveButtonLocator = By.id("save-portal-button");
    private By backToPortalsButtonLocator = By.id("back-button");
    private By titleForFirstPortalLocator = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[1]/td[3]");
    private By deleteButtonForFirstPortalLocator = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[1]/td[5]/div/button[2]/span");
    private By confirmDeleteButtonForFirstPortalLocator = By.xpath("//*[@id=\"portalDeleteDialog\"]/div/div/div[3]/button[2]");
    private By actualAlertMessageLocator = By.className("alert-success");
    private By UrlInputFieldLocator = By.name("url");
    private By regionSelectFieldLocator = By.name("region_id");
    
    public PortalsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getPanelHeadingText(){
        return driver.findElement(panelHeadingLocator).getText();
    }
    
    public void clickOnAddNewPortalsButton() {
        driver.findElement(addNewPortalsButtonLocator).click();
    }
    
    public void clickOnSaveButton() {
        driver.findElement(saveButtonLocator).click();
    }
    
    public void inputTitleText() {
        driver.findElement(titleFieldLocator).sendKeys(newPortalTitle);
    }
    
    public String getTitleText(){
        return newPortalTitle;
    }
    
    public void clickOnBackToPortalsButton() {
        driver.findElement(backToPortalsButtonLocator).click();
    }
    
    public String getTitleForFirstPortal() {
        return driver.findElement(titleForFirstPortalLocator).getText();
    }
    
    public void clickOnDeleteButtonForFirstPortal() {
        driver.findElement(deleteButtonForFirstPortalLocator).click();
    } 
    
    public void clickOnConfirmDeleteButtonForFirstPortal() {
        driver.findElement(confirmDeleteButtonForFirstPortalLocator).click();
    }
    
    public String getActualAlertMessage() {
        return driver.findElement(actualAlertMessageLocator).getText();
    }
    
    public void enterUrl(String url) {
        driver.findElement(UrlInputFieldLocator).sendKeys(url);
    }
    
    public void clickOnSelectRegion() {
        driver.findElement(regionSelectFieldLocator).click();
    }
}
