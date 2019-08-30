package ressuredTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*1) Test Status code
2) Log response
3) Verifying single content in response body
4) Verifying multiple contents in response body
5) Setting parameters & headers*/

public class BasicValidation_Json {
	
	//1) Test Status code
	@Test(priority=1)
	public void testStatusCode() {
		
		//no preex
		//given()
		
		when()
			.get("https://jsonplaceholder.typicode.com/posts/1")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
		//2) Log response
		//@Test(priority=2)
		public void testLogs() {
			
			given()
			.when()
				.get("http://services.groupkt.com/country/get/iso2code/IN")
			.then()
				.statusCode(200)
				.log().all();
		}
		
		//3) Verifying single content in response body
		
		//@Test(priority=3)
		public void testSingleContent() {
			given()
			.when()
				.get("http://services.groupkt.com/country/get/iso2code/IN")
			.then()
				.statusCode(200)
				.body("RestResponse.result.name", equalTo("India"));
				
			
		}
		
		//4) Verifying multiple contents in response body
		@Test(priority=4)
		public void testMultipleContents() {
			given()
			.when()
				.get("http://services.groupkt.com/country/get/all")
			.then()
				
				.body("RestResponse.result.name", hasItems("India", "United Kingdom of Great Britain and Northern Ireland"));
				
			
		}

		//5) Setting parameters & headers
		@Test(priority=4)
		public void testParametersAndHeaders() {
			given()
				.param("myName", "paven")
				.header("MyHeader","India")
			.when()
				.get("http://services.groupkt.com/country/get/iso2code/IN")
			.then()
				
				.statusCode(200)
				.log().all();
				
		}

		
}
