package restassuredbdd.test.qa;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restassured.qa.base.RestAssuredTestBase;


public class RestAssuredPostBasic extends RestAssuredTestBase
{
	public static HashMap request=new HashMap();
	public String name=RestUtils.generateRandomName();
	public String job=RestUtils.generateRandomOccupation();
	
	@BeforeClass
	public void setPostData()
	{
		request.put("name", name);
		request.put("job", job);
		RestAssured.baseURI=prop.getProperty("registeruser_baseuri");
		RestAssured.basePath=prop.getProperty("registeruser_basepath");
	}
	@Test
	public void executePostApi()
	{
		given()
			.contentType("application/json")
			.body(request)
		
		.when()
			.post()
		.then()
			.assertThat().body("name", equalTo(name)).body("job", equalTo(job))
			.and()
			.header("Content-Type", "application/json; charset=utf-8")
			.and()
			.statusCode(201);
	}
	@AfterClass
	public void printCheck()
	{
		System.out.println("Test");
	}

}
