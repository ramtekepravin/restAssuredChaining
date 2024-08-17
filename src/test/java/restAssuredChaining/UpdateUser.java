package restAssuredChaining;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


import java.util.*;


public class UpdateUser {
	
	@Test
	public void updateUser(ITestContext context)
	{
		Faker faker = new Faker();
		 
		 JSONObject data = new JSONObject();
		 data.put("name",faker.name().fullName());
		 data.put("gender", "female");
		 data.put("email",faker.internet().emailAddress());
		 data.put("status", "Active");
		 
		 String bearerToken = "d9e4fbccdbafe59102a74f8eff1788c9a94a561c80ec99cd9cd08072841d2367";
		 
		// int id = (Integer) context.getAttribute("userid") ;
		   int id = (Integer) context.getSuite().getAttribute("userid") ;
				 
				 given()
				   .headers("Authorization","Bearer "+bearerToken )
				   .contentType("application/json")
				   .pathParam("id",id)
				   .body(data.toString()) 
				   
				.when()
				   .put("https://gorest.co.in/public/v2/users/{id}")
				   
				 .then()
				   .statusCode(200)
				   .log().all();
				   	
			
	
	
	
	}
	 
	 
	
	 
}
