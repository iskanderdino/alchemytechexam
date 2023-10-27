package stepDefinitionsAPI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UsersApi_Steps {
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    @Given("I set url {string} {string} service request api endpoint")
    public void i_set_url_service_request_api_endpoint(String api, String method) {
        requestSpecification = RestAssured.given();
        //sample of method chaining
        Response response = requestSpecification
                .accept(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .and().baseUri("https://restful-booker.herokuapp.com/")
                .and().basePath("/" + api)
                .get();
//                .then().statusCode(200)
//                .and().body("bookingid", Matchers.notNullValue())
//                .and().body(JsonSchemaValidator.matchesJsonSchema());



//        validatableResponse = response.then();
//        validatableResponse.statusCode(200);
//        // validate booking id is not null
//        validatableResponse.body("bookingid", Matchers.notNullValue());
//        // validate booking firstname is not null
//        validatableResponse.body("booking.firstname",Matchers.notNullValue());
//        //validate json schema
//        validatableResponse.body(JsonSchemaValidator.matchesJsonSchema(file));


//        BookingsJsonObject[] bookingResonponse = validatableResponse.extract().as(BookingsJsonObject[].class);
    }
    @Then("I should receive http response code {string}")
    public void i_should_receive_http_response_code(String value) {
    }
}
