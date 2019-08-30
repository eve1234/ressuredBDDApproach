package ressuredTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class DeleteRequest {
	
	int emp_id=18017;
	
	@Test
	public void deleteEmployeeRecord() {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RestAssured.basePath="/delete/"+emp_id;
		
		//store request info below
		//verify the body response
		Response response=
			given()
			.when()
				.delete()
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.log().all()
				//extract the response
				.extract().response();
			//store as a String
			//then verify
			String jsonAsString=response.asString();
			Assert.assertEquals(jsonAsString.contains("successfully! deleted Records"), true);
		
		
	}

}
