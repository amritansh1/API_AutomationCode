package TestData;

public class PayloadBody {

	public static String AddPlace() {
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.356494,\r\n"
				+ "    \"lng\": 33.427662\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"ABC Test house\",\r\n"
				+ "  \"phone_number\": \"(+91) 4859674\",\r\n"
				+ "  \"address\": \"Delhi Carelon\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
	public static String updatePlace() {
		return "";
	}
}
