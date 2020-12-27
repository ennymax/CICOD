package CROWN.EKEDC.ENDPOINT;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerDetails {

    @Description("Select Payment Date")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void GetCustomerDetails(){

        RestAssured.baseURI="http://34.246.140.85:8080/integration/getFullCustomerDetails";

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/0249053558-01");
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: "+ responseBody);

        //1. get the status code and validate it:
        int statusCode = response.getStatusCode();
        System.out.println("the status code is: "+ statusCode);
        Assert.assertEquals(statusCode, 200);

        //2. get the status Line and validate it:
        String statusLine = response.getStatusLine();
        System.out.println("the status Line is: "+ statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

        //3. Headers. get the headers:
        Headers headers = response.getHeaders();
        System.out.println(headers);

        String contentType = response.getHeader("Content-Type");
        System.out.println("the value of content-type header is: "+ contentType);

        String contentLength = response.getHeader("Content-Length");
        System.out.println("the value of Content-Length header is: "+ contentLength);

        //4. Assert Response Body


    }
}
