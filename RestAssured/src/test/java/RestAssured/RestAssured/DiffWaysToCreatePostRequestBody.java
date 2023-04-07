package RestAssured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

//Different ways to create POST request body
//
//1. Post request body using Hashmap
//2. Post request body creation using Org.JSON
//3. Post request body creation using POJO class
//4. Post request using external json file data

public class DiffWaysToCreatePostRequestBody  {
	
//	post request body using HashMap
	
	  //@Test(priority=1)
      void testPostUsingHashMap() {
    	  
    	  HashMap<String, Object> data = new HashMap<String, Object>();
    	  
    	  data.put("name", "Ram");
    	  data.put("location", "Mumbai");
    	  data.put("phone", "1234567890");
    	  
    	  String courseArr[] = {"C", "C++"};
    	  data.put("courses", courseArr);
    	  
    	  given()
    	        .contentType("application/json")
    	        .body(data)
    	         
    	  .when()
    	        .post("http://localhost:3000/students")
    	  
    	  .then()
    	        .statusCode(201)
    	        .body("name", equalTo("Ram"))
    	        .body("location", equalTo("Mumbai"))
    	        .body("phone", equalTo("1234567890"))
    	        .body("courses[0]", equalTo("C"))
    	        .body("courses[1]", equalTo ("C++"))
    	        .header("Content-Type","application/json; charset=utf-8")
    	        .log().all();
    	        	  
      }
      
      // @Test(priority=1)
      void testPostUsingJsonLibrary() {
    	  
    	  JSONObject data = new JSONObject();
    	  
    	  data.put("name", "Shyam");
    	  data.put("location", "Mumbai");
    	  data.put("phone", "123456789");
    	  
    	  String courseArr[] = {"C", "C++"};
    	  data.put("courses", courseArr);
    	  
    	  given()
    	        .contentType("application/json")
    	        .body(data.toString())
    	         
    	  .when()
    	        .post("http://localhost:3000/students")
    	  
    	  .then()
    	        .statusCode(201)
    	        .body("name", equalTo("Shyam"))
    	        .body("location", equalTo("Mumbai"))
    	        .body("phone", equalTo("123456789"))
    	        .body("courses[0]", equalTo("C"))
    	        .body("courses[1]", equalTo ("C++"))
    	        .header("Content-Type","application/json; charset=utf-8")
    	        .log().all();
    	        	  
      }
       
       //@Test(priority=1)
       void testPostUsingPojo() {
     	  
    	   
    	  Pojo_PostRequest data = new Pojo_PostRequest();
     	  
     	  data.setName("Scott");
     	  data.setLocation("Mumbai");
     	  data.setPhone("123456789");
     	  
     	  String courseArr[] = {"C", "C++"};
     	  data.setCourses(courseArr);
     	  
     	  given()
     	        .contentType("application/json")
     	        .body(data)
     	         
     	  .when()
     	        .post("http://localhost:3000/students")
     	  
     	  .then()
     	        .statusCode(201)
     	        .body("name", equalTo("Scott"))
     	        .body("location", equalTo("Mumbai"))
     	        .body("phone", equalTo("123456789"))
     	        .body("courses[0]", equalTo("C"))
     	        .body("courses[1]", equalTo ("C++"))
     	        .header("Content-Type","application/json; charset=utf-8")
     	        .log().all();
     	        	  
       }
       
       @Test(priority=1)
       void testPostusingExternalJsonFile() throws FileNotFoundException {
     	  
    	   
    	 File f = new File(".\\body.json");
    	 FileReader fr = new FileReader(f);
    	 JSONTokener jt = new JSONTokener(fr);
    	 JSONObject data = new JSONObject(jt);
    	 
    	 
     	  
     	  given()
     	        .contentType("application/json")
     	        .body(data.toString())
     	         
     	  .when()
     	        .post("http://localhost:3000/students")
     	  
     	  .then()
     	        .statusCode(201)
     	        .body("name", equalTo("Scott"))
     	        .body("location", equalTo("Mumbai"))
     	        .body("phone", equalTo("123456789"))
     	        .body("courses[0]", equalTo("C"))
     	        .body("courses[1]", equalTo ("C++"))
     	        .header("Content-Type","application/json; charset=utf-8")
     	        .log().all();
     	        	  
       }
       
        
       @Test(priority=2)
       
       void testDelete()
       {
    	   given()
    	   
    	   .when()
    	         .delete("http://localhost:3000/students/19")
    	    .then()
    	          .statusCode(200);
    	   
       }
      
      
      }