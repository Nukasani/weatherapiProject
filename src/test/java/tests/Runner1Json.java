package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.Root;

public class Runner1Json 
{
	public static void main(String[] args) 
	{
		RestAssured.baseURI="http://api.weatherapi.com/v1/current.json";
		Response res=RestAssured.given()
					.queryParam("key","e9c3b0195be341c795281747202311")
					.queryParam("q","Ongole")
					.get();
		
		JsonPath jp=res.jsonPath();
		Root r=jp.getObject("",Root.class);
		System.out.println(r.location.country);
		System.out.println(r.location.region);
		System.out.println(r.location.name);
		System.out.println(r.current.temp_c);
		System.out.println(r.current.condition.text);
		System.out.println(r.current.wind_kph);

	}

}
