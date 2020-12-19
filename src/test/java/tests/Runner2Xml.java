package tests;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.Root;

public class Runner2Xml 
{

	public static void main(String[] args) throws Exception
	{
		RestAssured.baseURI="http://api.weatherapi.com/v1/current.xml";
		Response res=RestAssured.given()
		          .queryParam("key", "e9c3b0195be341c795281747202311")
				  .queryParam("q","Ongole")
				  .get();
		
		String output=res.getBody().asString();
		XmlMapper xm=new XmlMapper();
		Root r=xm.readValue(output,Root.class);
//		System.out.println(r.location.country);
		System.out.println(r.location.region);
//		System.out.println(r.location.name);
//		System.out.println(r.current.temp_c);
//		System.out.println(r.current.condition.text);
//		System.out.println(r.current.wind_kph);

	}

}
