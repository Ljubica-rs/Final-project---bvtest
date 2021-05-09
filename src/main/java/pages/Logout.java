package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {
    private WebDriver driver;
    
    private By navDropDownButtonLocator = By.className("dropdown-toggle");
    private By logoutButtonLocator = By.linkText("Logout");

    public Logout(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOnNavDropDownButton() {
        driver.findElement(navDropDownButtonLocator).click();
    }
    
    public void clickOnLogoutButton() {
        driver.findElement(logoutButtonLocator).click();
    }
    
}
