package ressuredTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

/*1) Verifying Single content in XML Response
2) Verifying Multiple contents in XML Response
3) Verifying all the content in XML response in one go
5) XPath with text() function
4) Find values using XML Path in XML response */

public class BasicValidation_Xml {
	
	
	//1) Verifying Single content in XML Response
	@Test(priority=1)
	public void testSingleContent() {
		
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		
			.then()
				.body("CUSTOMER.ID", equalTo("15"))
				.log().all();
		
		
	}
	
	//2) Verifying Multiple contents in XML Response
	@Test(priority=2)
	public void testMultpleContent() {
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		
			.then()
				.body("CUSTOMER.ID", equalTo("15"))
				.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
				.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
				.body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
				.body("CUSTOMER.CITY", equalTo("Seattle"));
				

	}
	
	//3) Verifying all the content in XML response in one go
	
	@Test(priority=3)
	public void testMultpleContentInOneGo() {
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		
			.then()
				.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));
				

	}
	
	//4) Find values using XML Path in XML response
	@Test(priority=4)
	public void testUsingXPath1() {
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		
			.then()
			//xml
			.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill")));
				
		
	}
	
	//5) XPath with text() function
	@Test(priority=5)
	public void testUsingXPath2() {
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		
			.then()
			//xpath
			.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
			.log().all();
		
	}

}
