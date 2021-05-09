package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesPage {
    private WebDriver driver;
    private By panelHeadingLocator = By.className("panel-heading");
    private By addNewCategoryButtonLocator = By.className("pull-right");
    
    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getPanelHeadingText(){
        return driver.findElement(panelHeadingLocator).getText();
    }
    
    public void clickOnAddNewCategoryButton() {
        driver.findElement(addNewCategoryButtonLocator).click();
    }
}

