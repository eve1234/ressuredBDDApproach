package serialisationDeserialisation;

import java.util.ArrayList;
import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StudentAPITestNoSerialization {
	
	public HashMap map = new HashMap();
	
	
	//post requests creates a new student record
	@Test(priority=1)
	public void createNewStudent() {
		map.put("id", "101");
		map.put("firstName", "David");
		map.put("lastName", "White");
		map.put("email", "d.white@gmail.com");
		map.put("programme", "Developer");
		
		//contains multi value
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("java"); 
		coursesList.add("selenium");
		map.put("courses", coursesList);
		
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("http://localhost:8085/student")
		.then()
			.statusCode(201)
			.assertThat()
			.body("msg", equalTo("Student added"));
		
	}
	
	//get request to retrieve student details
	@Test(priority=2)
	public void getStudentDetails() {
		
		given()
			.when()	
				.get("http://localhost:8085/student/101")
			.then()
				.statusCode(200)
				.assertThat()
				.body("id", equalTo(101))
				.log().all();
		
		
	}
}
