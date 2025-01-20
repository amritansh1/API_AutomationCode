package Test;

import org.testng.Assert;

import TestData.JsonArrayData;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		JsonPath js=new JsonPath(JsonArrayData.getJsonArray());
		int count=js.getInt("courses.size()");
		System.out.println("Courses array size: "+count);
		int purAmount=js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount: "+purAmount);
		String title1=js.get("courses[0].title");
		System.out.println("Title1 :"+title1);
		int sumPrice=0;
		for(int i=0;i<count;i++) {
			String title=js.get("courses["+i+"].title");
			System.out.println("Title "+(i+1)+":"+title);
			if(title.equals("RPA")) {
				System.out.println(js.getInt("courses["+i+"].copies"));
			}
			sumPrice+=js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies");
		}
		System.out.println("Purchase smount="+purAmount);
		System.out.println("Sum smount="+sumPrice);
		
		Assert.assertEquals(purAmount, sumPrice);
	}

}
