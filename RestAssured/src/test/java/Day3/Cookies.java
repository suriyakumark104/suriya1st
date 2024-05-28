package Day3;

import static io.restassured.RestAssured.*;

import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
public class Cookies {
	
	@Test
	void cookies() {
		
	Response res = given()
	
	.when().get("https://www.google.com/");
	
//	String cookie_value = res.getCookie("AEC");
	
	Map<String,String> cookie_values = res.getCookies();
	
	for(String s : cookie_values.keySet()) {
		String cookies = res.getCookie(s);
		System.out.println(s+" = "+cookies);
	}
	
//	System.out.println("ACE cookie value is : "+cookie_value);
	
//	.log().all();

//to get single specified cookie	
//	String cookie = res.getCookie("NID");
//	System.out.println(cookie);
	
	}

}
