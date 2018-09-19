package rest_api;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class RestApiTesting {
	
	@BeforeClass
	public void setUp() {
		baseURI ="http://www.batch8-api-site.dev.cc/wp-json";
		basePath = "/wp/v2/";
	}
	
	@Test
	public void sampleTest() {
		String url = "http://www.batch8-api-site.dev.cc/wp-json/wp/v2/posts/18";
	given().relaxedHTTPSValidation()
	.and().accept(ContentType.JSON)
	.and().contentType(ContentType.JSON)
	.when().get(url).then().log().all()
	.and().body("id", equalTo(18)).body("title.rendered", equalTo("my  title again"));


		
	}
	
	@Test
	public void sampleTest1() {
		String url = "http://www.batch8-api-site.dev.cc/wp-json/wp/v2/posts/18";
	
	
	given().relaxedHTTPSValidation()
	.and().accept(ContentType.JSON)
	.and().contentType(ContentType.JSON)
	.when().get("/posts/18").then().log().all()
	.and().body("id", equalTo(18)).body("title.rendered", equalTo("my  title again"));

		
	}
	
	@Test
	public void postVerification() {
		int random = new Random().nextInt(99999);
		
		String url = "http://www.batch8-api-site.dev.cc/wp-json/wp/v2/posts/";
		
		Map <String, String> newPost = new HashMap();
		
		newPost.put("title", "Wednesday Post");
		newPost.put("status", "publish");
		newPost.put("slug", "All News");
		
		
		
		/*
		 *  "employee_id": 9890,
            "first_name": "Angela",
            "last_name": "Angle",
            "email": "abc9912@gmail.com",
            "phone_number": "158.456.7890",
            "hire_date": "2017-08-18T00:00:00Z",
            "job_id": "IT_PROG",
            "salary": null,
            "commission_pct": null,
            "manager_id": null,
            "department_id": null,
		 * 
		 */
		
	Response response =	given().relaxedHTTPSValidation().and().accept(ContentType.JSON)
		.and().contentType(ContentType.JSON).and().log().all().and().body(newPost).when().get("/posts");
		
		
	Map <String, String> getPost = response.body().as(Map.class);
	
	for(Object key: newPost.keySet()) {
		System.out.println(newPost.get(key) + "<>" +getPost.get(key));
		assertEquals(newPost.get(key),getPost.get(key));
	}
	}
	@Test
	public void testWithHamcrest() {
		int a =5, b= 5, c=6;
		
		assertTrue(a==b);
//		assertEquals(a,c);
		
		assertThat(a,equalTo(b));
		
		assertThat("abc", is("abcd"));
		
		
	}
	

}
