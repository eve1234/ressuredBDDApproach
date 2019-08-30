package ressuredTest;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutRequest {
	
	
	public static HashMap map = new HashMap();
	
	//capture the data dynamically
	String empName=RestUtils.empName();
	String empSal=RestUtils.empSal();
	String empAge=RestUtils.empAge();
	int emp_id=18015;
	
	
	@BeforeClass
	public void putDatat() {
		map.put("name", empName);
		map.put("salary", empSal);
		map.put("age", empAge);
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/" + emp_id;
	}
	
	@Test
	public void testPut() {
		
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
	}

}
