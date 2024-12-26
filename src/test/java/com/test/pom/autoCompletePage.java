package com.test.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class autoCompletePage {

	
	
	public autoCompletePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//label[@id='email-field']")  private WebElement emailTextBx;
	
	@FindBy(xpath = "//label[@id='password-field']") private WebElement pwdTextBx;
	
	@FindBy(xpath = "//lable[@id='input-field']") private WebElement inputFiled;
	
	@FindBy(xpath = "//button[@id='next-button']") private WebElement nextButton;
	
	@FindBy(xpath = "//ul[@class='suggestions']/li")  private List<WebElement> suggestions;
	
	@FindBy(xpath = "//p[text()='Success! Your response has been recorded.']") private WebElement successMsg;
	
	@FindBy(xpath = "//span[text()='Error: Invalid input. Please select a valid suggestion']") private  WebElement errorMsg;
	
	
	
	
	//Action methods
	
	public void enterCredentails(String email,String pwd) {
		
		emailTextBx.sendKeys(email);
		pwdTextBx.sendKeys(pwd);
	}
			
			
	public void enterInputField(String text) {
		
		inputFiled.sendKeys(text);
		
		
	}
	
public void clearInputField() {
		
		inputFiled.clear();
		
		
	}
	
	public boolean enterInputFieldDisplayed() {
		
		return inputFiled.isDisplayed();
		
	}
	
	
    public boolean nextButtonDisplayed() {
		
		return nextButton.isDisplayed();
		
	}
    
 public boolean suggestionsDisplayed() {
		
		return suggestions.isEmpty();
		
	}
	
    public List<WebElement> getAutoSuggestions() {
	
	
	return suggestions;
	}
	

    public void clickNextBtn() {
	
	
    	nextButton.click();	
   }
    
    
    public boolean successMsgDisplayed() {
    	
		return successMsg.isDisplayed();
    	
    }
    
    
 public boolean errorMsgDisplayed() {
    	
		return errorMsg.isDisplayed();
    	
    }
}
