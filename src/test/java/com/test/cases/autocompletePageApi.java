package com.test.cases;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.test.utilites.readProperty;

import io.restassured.http.ContentType;




public class autocompletePageApi {

	readProperty read = new readProperty();
	
	public void getStoredData() {
		
		
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get(read.readResources("config").getString("getAPiUrl"))//https://test.api.docs/
		.then()
		.statusCode(200)
		.log().all();//response body 
		
	}
	
	
}
