package rest_users;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPath_Practice2 {
	
	@Test
	public void getAllDriverFirstName() {
		
		Response response = given().
		when().get("http://ergast.com/api/f1/drivers.json");
		
		JsonPath jp = response.jsonPath();
//		List<Object>lst = jp.getList("MRData.DriverTable.Drivers.givenName");
		List<String>lst = jp.getList("MRData.DriverTable.Drivers.givenName", String.class);
		System.out.println(lst);
		List<Object> lst3 = jp.getList("MRData.DriverTable.Drivers");
		System.out.println(lst3);
		Map map = jp.getMap("MRData.DriverTable.Drivers[0]");
		System.out.println(map);
		System.out.println(map.keySet());
		System.out.println(map.values());
		Map<String, String>map1 = jp.getMap("MRData.DriverTable.Drivers[1]", String.class, String.class);
		System.out.println(map1);
		List<Object> name = jp.get("MRData.DriverTable.Drivers.findAll{it.givenName=='George'}");
		
		System.out.println(name);
		
		Driver driver = jp.getObject("MRData.DriverTable.Drivers[1]", Driver.class);
		
		System.out.println(driver);
		
	}
	

}
