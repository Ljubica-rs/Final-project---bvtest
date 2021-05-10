package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesPage {
    private WebDriver driver;
    private By panelHeadingLocator = By.className("panel-heading");
    private By addNewCategoryButtonLocator = By.className("pull-right");
    private By titleFieldLocator = By.id("title");
     private String newPortalTitle = Helper.generateTitle2();
     private By saveButtonLocator = By.id("save-category-button");
     private By actualAlertMessageLocator = By.className("alert-success");
     private By backToCategoriesButtonLocator = By.id("back-button");
    
    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getPanelHeadingText(){
        return driver.findElement(panelHeadingLocator).getText();
    }
    
    public void clickOnAddNewCategoryButton() {
        driver.findElement(addNewCategoryButtonLocator).click();
    }
    
    public void inputTitleText() {
        driver.findElement(titleFieldLocator).sendKeys(newPortalTitle);
    }
    
    public void clickOnSaveButton() {
        driver.findElement(saveButtonLocator).click();
    }
    
     public String getTitleText(){
        return newPortalTitle;
    }
     
     public String getActualAlertMessage() {
        return driver.findElement(actualAlertMessageLocator).getText();
    }
     
     public void clickOnBackToCategoriesButton() {
        driver.findElement(backToCategoriesButtonLocator).click();
    }
}

