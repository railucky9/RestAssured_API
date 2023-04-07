package RestAssured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class CookiesDemo {
	
     //@Test(priority=1)
	void testCookies()
	{
		
		given()
		
		      .when()
		            .get("https://www.google.com/")
		            
		       .then() 
		              .cookie("AEC", "AUEFqZeaksWqQnqAH0gH-tuj6wFvXKD1m9upZqW101k9f17Uo2r8Ak86Tg")
		             .log().all();
	}
     
     
     @Test
     void getCookiesInfo() {
    	 
    	 Response res=given()
    	       .when()
    	             .get("https://www.google.com/");
    	 
    	 // get single cookie info
    	 
//    	 String cookie_values = res.getCookie("AEC");
//    	 System.out.println("Value of cookie is =====> "+cookie_values);
    	 
    	 //get all cookies info
    	 
    	Map<String, String> cookies_values = res.getCookies();
    	
    	System.out.println(cookies_values.keySet());
    	
    	for(String k : cookies_values.keySet())
    	{
    		String cookie_value = res.getCookie(k);
    		System.out.println(k+"      "+cookie_value);
    	}
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 //
     }
}
