package serialisationDeserialisation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class VideoGameAPITestWithSerializationXML {
	
	@Test(priority=1)
	public void testVideoGameSerializationXml() {
		
		VideoGame myVideoGame=new VideoGame();
		myVideoGame.setId(12);
		myVideoGame.setName("xyz1234");
		myVideoGame.setReleaseDate("2019-06-17");
		myVideoGame.setReviewScore(90);
		myVideoGame.setCategory("Driving");
		myVideoGame.setRatiing("Five");
		
		given()
			.contentType("application/xml")   //("applcation/xml", ContentType.TEXT)
			.body(myVideoGame)
		.when()
			.get("http://localhost:8080/app/videogames")
		.then()
			.log().all()
			.body(equalTo("{\"status\": \"Record Added Successfully\"}"));
		
	}
	
	@Test(priority=2)
	public void testVideoGameDeSerilizationXml() {
		//data is available in a form of file
		//response as a file convert as student object
		//store in a student variable object
		VideoGame myVideoGame=get("http://localhost:8080/app/videogames/12").as(VideoGame.class);
		System.out.println(myVideoGame.toString());
		//can't make 
		//the method assertEquals((Object, Object) is ambiguous for the type assert
		Assert.assertEquals((Object)myVideoGame.getId(), 12);
	
	}

}
