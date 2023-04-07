package RestAssured.RestAssured;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;


public class ParsingJSONReponseData {
	
	@Test(priority=1)
	void testJSONResponse()
	{
		/*approach 1
		given()
		
		      .contentType(ContentType.JSON)
		      .when()
		           .get("http://localhost:3000/students")
		      .then()
		            .statusCode(200)
		            .header("Content-Type", "application/json; charset=utf-8")
		            .body("students[0].courses[0]", equalTo("java"));*/
		
		Response res = given()
				
				.contentType(ContentType.JSON)
				
		      .when()
		          .get("http://localhost:3000/students");
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		
		String coursename = res.jsonPath().getString("students[0].courses[0]").toString();
		Assert.assertEquals(coursename, "java");
		
		
		      
		
	}

}
