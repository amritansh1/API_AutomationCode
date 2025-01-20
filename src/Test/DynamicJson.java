package Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestData.LibraryData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
//import TestData.LibraryData;
import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	
//	public static void main(String[] args) {
	@Test(dataProvider="LibrabyData")
	public void addBook(String isbn,String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all().header("Content-Type", "application/json").
		body(LibraryData.addBookPara(isbn,aisle)).
		when().post("/Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).extract().asString();
		JsonPath js=new JsonPath(response);
		String id=js.get("ID");
		String message=js.get("Msg");
		System.out.println("ID :"+id);
		System.out.println("Message :"+message);
	}
	
	@DataProvider(name="LibrabyData")
	public Object[][] getData(){
		return new Object[][] {{"sfa","435"},{"grtg","456"},{"bted","454"}};
	}
}
