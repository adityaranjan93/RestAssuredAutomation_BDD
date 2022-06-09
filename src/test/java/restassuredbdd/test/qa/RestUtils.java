package restassuredbdd.test.qa;
import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils 
{
 public static String generateRandomName()
 {
	 String name=RandomStringUtils.randomAlphabetic(1);
	 return ("James"+name);
 }
 public static String generateRandomOccupation()
 {
	 String occupation=RandomStringUtils.randomAlphabetic(1);
	 return (occupation);
 }
}
