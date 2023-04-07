package RestAssured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;


//given()
//
// content type, set cookies, add auth, add param, set headers into etc... girkens language
// 
// when ()
// 
// get(), post(), put(), delete
// 
// then()
// 
// validate status code, extract response, extract headers cookies & response body...

public class HTTPRequest {
      
	int id;
	@Test(priority=1)
	void getUsers() {
		
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
		
	}
	
	@Test(priority=2)
	void createUsers() {
		
		HashMap data = new HashMap();
		
		data.put("name", "gourav");
		data.put("job", "trainer");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
//		.then()
//		.statusCode(201)
//		.log().all();
//		
	}
	
	@Test(priority=3, dependsOnMethods= {"createUsers"})
	void updateUser()
	{
		
		HashMap data = new HashMap();
		data.put("name", "gourav");
		data.put("job", "teacher");
		
		given()
		      .contentType("application/json")
		      .body(data)
		
		.when()
		      .post("https://reqres.in/api/users/"+id)
		     
		
		.then()
		      .statusCode(201)
		      .log().all();
		      
	}
	
	@Test(priority=4)
	void deleteUser()
	{
		given()
		
		.when()
		
		.delete("https://reqres.in/api/users/"+id)
		
		
		.then()
		.statusCode(204 )
		.log().all();
	}
	
	
	
	
	
}
