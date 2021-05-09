package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegionsPage {
    private WebDriver driver;
    private By panelHeadingLocator = By.className("panel-heading");
    private By addNewRegionsButtonLocator = By.className("pull-right");
    private By titleFieldLocator = By.id("title");
    private By saveButtonLocator = By.id("save-region-button");
    private By actualAlertMessageLocator = By.className("alert-success");
    private String newRegionTitle = Helper.generateTitle();
    private By backToRegionsButtonLocator = By.id("back-button");
    private By deleteButtonForFirstRegionLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[5]/div/button[2]");
    private By confirmDeleteButtonForFirstRegionLocator = By.xpath("//*[@id=\"regionDeleteDialog\"]/div/div/div[3]/button[2]");
    private By titleForFirstRegionLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[3]");
    private By disableButtonForFirstRegionLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[5]/div/button[1]/span");
    private By confirmDisableButtonForFirstRegionLocator = By.xpath("//*[@id=\"regionDisableDialog\"]/div/div/div[3]/button[2]");
    private By enableButtonForFirstRegionLoactor = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[5]/div/button[1]/span");
    private By confirmEnableButtonForFirstRegionLoactor = By.xpath("//*[@id=\"regionEnableDialog\"]/div/div/div[3]/button[2]");
    private By statusOfFirstRegionLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[4]/span");
    private By titleForThirdRegionLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[3]/td[3]");
    private By editButtonForThirdRegionLocator = By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[3]/td[5]/div/a/span");
    
    public RegionsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getPanelHeadingText(){
        return driver.findElement(panelHeadingLocator).getText();
    }
    
    public void clickOnAddNewRegionsButton() {
        driver.findElement(addNewRegionsButtonLocator).click();
    }
    
    public void inputTitleText() {
       //String newRegionTitle = Helper.generateTitle();
        driver.findElement(titleFieldLocator).sendKeys(newRegionTitle);
    } 
    public String getTitleText(){
        return newRegionTitle;
    }
    
    public void clickOnSaveButton() {
        driver.findElement(saveButtonLocator).click();
    }
    
    public String getActualAlertMessage() {
        return driver.findElement(actualAlertMessageLocator).getText();
    }
    
    public void clickOnBackToRegionsButton() {
        driver.findElement(backToRegionsButtonLocator).click();
    }
    
    public void clickOnDeleteButtonForFirstRegion() {
        driver.findElement(deleteButtonForFirstRegionLocator).click();
    }
    
    public void clickOnConfirmDeleteButtonForFirstRegion() {
        driver.findElement(confirmDeleteButtonForFirstRegionLocator).click();
    }
    
    public String getTitleForFirstRegion() {
        return driver.findElement(titleForFirstRegionLocator).getText();
    }
    
    public void clickOnDisableButtonForFirstRegion() {
        driver.findElement(disableButtonForFirstRegionLocator).click();
    }
    
    public void clickOnConfirmDisableButtonForFirstRegion() {
        driver.findElement(confirmDisableButtonForFirstRegionLocator).click();
    }
    
    public void clickOnEnableButtonForFirstRegion() {
        driver.findElement(enableButtonForFirstRegionLoactor).click();
    }
    public void clickOnConfirmEnableButtonForFirstRegion() {
        driver.findElement(confirmEnableButtonForFirstRegionLoactor).click();
    }
    
    public String statusOfFirstTitle(){
        return driver.findElement(statusOfFirstRegionLocator).getText();
    }
    
    public String getTitleForThirdRegion() {
        return driver.findElement(titleForThirdRegionLocator).getText();
    }
    
    public void clickOnEditButtonForThirdRegion() {
        driver.findElement(editButtonForThirdRegionLocator).click();
    }
    
    public void clearTitleField(){
        driver.findElement(titleFieldLocator).clear();
    }
}

