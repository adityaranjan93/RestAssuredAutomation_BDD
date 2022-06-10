package restassuredbdd.test.qa;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restassured.qa.base.RestAssuredTestBase;

public class RestAssuredPutBasic extends RestAssuredTestBase
{
	public static HashMap putreq;
	public static String name=RestUtils.generateRandomName();
	public static String job=RestUtils.generateRandomOccupation();
	
	@BeforeClass
	public void setPutData()
	{
		putreq=new HashMap();
		putreq.put("name",name);
		putreq.put("job",job);
		RestAssured.baseURI=prop.getProperty("registeruser_baseuri");
		RestAssured.basePath=prop.getProperty("update_basepath");
	}
	
	@Test
	public void executePutApi()
	{
		given()
			.contentType("application/json")
			.body(putreq)
		.when()
			.put()
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.assertThat().body("name", equalTo(name))
			.and()
			.assertThat().body("job", equalTo(job))
			.log().all();
		
		
	}
}
