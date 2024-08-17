package restAssuredChaining;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	
	@Test
	public void delete(ITestContext context)
	{
		// int id = (Integer) context.getAttribute("userid");
		int id = (Integer) context.getSuite().getAttribute("userid") ;
		
		String bearerToken = "d9e4fbccdbafe59102a74f8eff1788c9a94a561c80ec99cd9cd08072841d2367";
		
		given()
		   .headers("Authorization","Bearer "+bearerToken )
		   .contentType("application/json")
		   .pathParam("id",id)
		   
		   .when()
		   .delete("https://gorest.co.in/public/v2/users/{id}")
		   
		   .then()
		     .statusCode(204);
		 
		
		
	}

}
