package restAssuredChaining;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	
  @Test	
  public void getUser(ITestContext context)
  {
	  
	  
	//  int id = (Integer) context.getAttribute("userid") ; // for all test at test level
	    int id = (Integer) context.getSuite().getAttribute("userid") ;
	  
	  String bearerToken = "d9e4fbccdbafe59102a74f8eff1788c9a94a561c80ec99cd9cd08072841d2367";
	  
	   given()
	    .headers("Authorization","Bearer "+bearerToken )
	    .pathParam("id", id)
	    
	  .when()
	     .get("https://gorest.co.in/public/v2/users/{id}")
	  
	  .then()
	     .statusCode(200)
	     .log().all();
	  
  }

}
