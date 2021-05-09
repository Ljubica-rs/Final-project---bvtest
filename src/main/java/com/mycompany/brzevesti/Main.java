/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.brzevesti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Ljubica
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // WebDriver driver = new ChromeDriver();
       // driver.manage().window().fullscreen();
       // driver.get("http://bvtest.school.cubes.rs/login");
        
       // WebElement emailField = driver.findElement(By.name("email"));
       // emailField.sendKeys("qa@cubes.rs");
        
       // WebElement passwordField = driver.findElement(By.name("password"));
       // passwordField.sendKeys("cubesqa");
        
       // WebElement loginButton = driver.findElement(By.className("btn-primary"));
       // loginButton.click();
        
       // WebElement navCategory = driver.findElement(By.linkText("Categories"));
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
        
       // WebElement addNewCategoryButton = driver.findElement(By.className("pull-right"));
       // addNewCategoryButton.click();
        
        //WebElement titleField = driver.findElement(By.id("title"));
       // String newCategoryTitle = "Ljubica1";
       // titleField.sendKeys(newCategoryTitle);
        
        //WebElement saveButton = driver.findElement(By.id("save-category-button"));
        //saveButton.click();
        
       // String expectedResult = "Category \"" + newCategoryTitle + "\" has been successfully saved";
       // String actualResult = driver.findElement(By.className("alert-success")).getText();
        
        // if (expectedResult.equals(actualResult)) {
        //    System.out.println("Test je prosao");
       // } else {
       //     System.out.println("Test nije prosao");
       // }
       // driver.quit();
    }
    
}
