package com.test.cases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.intilization.initilaizeTest;
import com.test.pom.autoCompletePage;



public class autocompleteFormTestCases extends initilaizeTest {
	
	
	autoCompletePage page = new autoCompletePage(driver);
	
	@Test(priority = 1,description = "verify login with valid/invalid credentails")
	public void testLogin() {
		
		page.enterCredentails("test123@gmail.com", "12345677");
		
     Assert.assertEquals(page.enterInputFieldDisplayed(), true);
	}
	
	@Test(priority = 2,description = "Verify Autocomplete page should have the text box , suggestion list ,next button,submit button")
	public void pageFiledsDisplayed() {
		
		Assert.assertEquals(page.enterInputFieldDisplayed(), true);	
	
		
		page.enterInputField("agile");
		Assert.assertEquals(page.suggestionsDisplayed(), true);	
		
		Assert.assertEquals(page.nextButtonDisplayed(), true);	
	}
	
	@Test(priority = 3, description = "Verify tex box input,user should get autosuggestion on partial text ")
	public void autoSuggestionsTest() {
		
		page.enterInputField("agile");
		Assert.assertEquals(page.suggestionsDisplayed(), true);	
		
		for(WebElement w : page.getAutoSuggestions()) {
			
			System.out.println("Suggestions-"+w.getText());
			
			
		}
		
		Assert.assertEquals(page.getAutoSuggestions().get(0).getText(),"agile methodology");
		Assert.assertEquals(page.getAutoSuggestions().get(1).getText(),"agile methodology process");
		Assert.assertEquals(page.getAutoSuggestions().get(1).getText(),"agile methodology process testing");
	
	}
	
	@Test(priority = 4, description = "Verify text box ,auto suggestion will stop for unknown text entry to the backhand ")
	public void autoSuggestionStopTest() {
		
		page.clearInputField();
		page.enterInputField("page assingment tpanda");
		Assert.assertEquals(page.suggestionsDisplayed(), false);		
		
		
	}
	
	@Test(priority = 5, description ="Verify ,post clicking the Next button a new entry should be created ")
	public void sumbitRecordTest() {
		
		page.enterInputField("agile");
		page.getAutoSuggestions().get(0).click();
		
		page.clickNextBtn();
		
		Assert.assertEquals(page.successMsgDisplayed(),"Success! Your response has been recorded.");
		
	}
	
	
	@Test(priority = 6 ,description = "api test")
	public void apiTest() {
		
		
		
		
		
	}
	
	
	
}
