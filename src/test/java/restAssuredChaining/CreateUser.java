package restAssuredChaining;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import org.json.JSONObject;



public class CreateUser {
	
	@Test
	public void createUser(ITestContext context) // ITestContext interface is used to link the data in all class 
	{
	  
		 Faker faker = new Faker();
		 
		 JSONObject data = new JSONObject();
		 data.put("name",faker.name().fullName());
		 data.put("gender", "male");
		 data.put("email",faker.internet().emailAddress());
		 data.put("status", "InActive");
		 
		 String bearerToken = "d9e4fbccdbafe59102a74f8eff1788c9a94a561c80ec99cd9cd08072841d2367";
		 
		 int id =
		 
		 given()
		   .headers("Authorization","Bearer "+bearerToken )
		   .contentType("application/json")
		   .body(data.toString()) 
		   
		.when()
		   .post("https://gorest.co.in/public/v2/users")
		   .jsonPath().getInt("id"); 
		 
		// context.setAttribute("userid", id); // for running all test at test level 
		 
		   context.getSuite().setAttribute("userid", id);
	}

}
