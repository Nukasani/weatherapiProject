package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Smoke2Xml 
{

	public static void main(String[] args) 
	{
		RestAssured.baseURI="http://api.weatherapi.com/v1/current.xml";
		Response res=RestAssured.given()
		          .queryParam("key", "e9c3b0195be341c795281747202311")
				  .queryParam("q","Ongole")
				  .get();
		
		
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
 
	}

}
