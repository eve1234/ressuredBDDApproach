package serialisationDeserialisation;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class StudenttAPITestWithSerialization {
	
	
	@Test(priority=1)
	public void createNewStudentSerilization() {
		
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		Student stu=new Student();
		stu.setId(101);
		stu.setFirstName("John");
		stu.setLastName("White");
		stu.setEmail("johnwhite@gmail.com");
		stu.setProgramme("Computer Science");
		stu.setCourses(coursesList);
		
		given()
			.contentType(ContentType.JSON)
			.body(stu)
		.when()
			.post("http://localhost:8085/student")
			
		.then()
			.statusCode(201)
			.assertThat().body("msg", equalTo("Student added"))
		.log().all();
			
		
	}
	
	@Test(priority=2)
	public void getStudentRecordDeSerilization() {
		//data is available in a form of file
		//response as a file convert as student object
		//store in a student variable object
		Student stu=get("http://localhost:8085/student/101").as(Student.class);
		System.out.println(stu.getStudentRecord());
		//can't make 
		//the method assertEquals((Object, Object) is ambiguous for the type assert
		Assert.assertEquals((Object)stu.getId(), 101);
	
	}
}
