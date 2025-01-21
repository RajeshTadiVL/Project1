package testcases;
import io.restassured.RestAssured;
import io.restassured.response.Response;
//import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CatFactAPI {

	public static void main(String[] args) {
		
		 // Set the base URI for the API
        RestAssured.baseURI = "https://catfact.ninja";

        // Send the GET request with the query parameters and headers
        Response response = given()
            .header("accept", "application/json")
            .header("X-CSRF-TOKEN", "6xWzZOdoH4C2vmzjyYUZC9x7t1q4RkIy6x4n8gXD")
            .queryParam("max_length", 10)  // Query parameter for maximum length
            .queryParam("limit", 3)        // Query parameter for limit
            .when()
            .get("/facts")
            .then()
            .statusCode(200)  // Assert that the status code is 200 (OK)
            .extract().response();

        // Print the response body
        System.out.println("Response Body: " + response.asString());
        // Validate the response fields
        response.then()
            // Validate 'data' is an empty array
            .body("data", empty())  // Ensures that 'data' is empty

            // Validate the 'total' is 0
            .body("total", equalTo(0))

            // Validate pagination fields
            .body("current_page", equalTo(1))
            .body("first_page_url", equalTo("https://catfact.ninja/facts?page=1"))
            .body("last_page_url", equalTo("https://catfact.ninja/facts?page=1"))
            .body("next_page_url", equalTo(null))
            .body("prev_page_url", equalTo(null))

            // Check if the pagination links are correct
            .body("links[0].label", equalTo("Previous"))
            .body("links[0].active", equalTo(false))
            .body("links[1].label", equalTo("1"))
            .body("links[1].active", equalTo(true))
            .body("links[2].label", equalTo("Next"))
            .body("links[2].active", equalTo(false));
    }
  
	

}
