package Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import TestData.PayloadBody;
//The type org.hamcrest.Matcher cannot be resolved. It is indirectly referenced from required type 
public class SampleAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		//Add Place
		String res=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(PayloadBody.AddPlace())
		.when().log().all().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println("Response of given request: "+res);
		
		JsonPath js=new JsonPath(res);
		String placeId=js.get("place_id");
		System.out.println("Place ID = "+placeId);
		String newAdd="Address Test 01";
		
		//Update Place
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAdd+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
//		Get Place
		String resGet=given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().log().all().statusCode(200).extract().asString();
		
		JsonPath js1=new JsonPath(resGet);
		String addRun=js1.get("address");
		System.out.println("Updated Address: "+addRun);
		Assert.assertEquals(newAdd,addRun);

	}

}
