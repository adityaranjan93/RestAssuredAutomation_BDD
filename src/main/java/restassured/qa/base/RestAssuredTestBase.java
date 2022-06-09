package restassured.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RestAssuredTestBase 
{
	public static Properties prop;
	public RestAssuredTestBase()
	{
		try {
			FileInputStream fin= new FileInputStream("D:\\Selenium_Workspace\\RestAssuredAutomationBDD\\src\\main\\java\\restassured\\util\\config\\config.properties");
			prop=new Properties();
			prop.load(fin);	
			} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
