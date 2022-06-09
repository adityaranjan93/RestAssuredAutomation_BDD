package restassuredbdd.test.qa;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredGetBasic 
{
	@Test
	public void executeGetBasic()
	{
		given()
		.when()
		 .get("https://reqres.in/api/users/2")
		 .then()
		 	.statusCode(200)
		 	.statusLine("HTTP/1.1 200 OK")
		 	.header("Content-Type", "application/json; charset=utf-8")
		 	.header("Server", "cloudflare")
		 	.assertThat().body("data.first_name", equalTo("Janet"));
		
		
		 
		 	
	}
	

}
