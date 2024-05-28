package Day1;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class Requests {
	
	int id;
	@Test(priority = 1)
	void getrequests() {
		
		when().get("https://reqres.in/api/unknown")
	
		.then().statusCode(200).log().all();
	}
	
	@Test(priority = 2)
	void postrequest() {
		
		HashMap hm = new HashMap();
		hm.put("name", "suriya");
		hm.put("job", "tester");
		
		id=given().contentType("application/json")
		.body(hm)
		
		.when().post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		System.out.println(id);
	}
	@Test(priority = 3, dependsOnMethods = {"postrequest"})
	void putrequest() {
		HashMap hm = new HashMap();
		hm.put("name", "viveka");
		hm.put("job", "Data Scientist");
		
		given().contentType("application/json")
		
		.when().put("https://reqres.in/api/users"+id)
		
		.then().statusCode(200);
	}
	
	@Test(priority = 4)
	void deleterequest() {
		
		when().delete("https://reqres.in/api/users"+id)
		
		.then().statusCode(204)
		.log().all();
	}
	
	

}
