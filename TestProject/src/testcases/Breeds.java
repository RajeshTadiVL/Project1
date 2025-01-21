package testcases;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Breeds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Set the base URI for the API
        RestAssured.baseURI = "https://catfact.ninja";

        // Send the GET request to the API
        Response response = given()
            .header("accept", "application/json")
            .header("X-CSRF-TOKEN", "6xWzZOdoH4C2vmzjyYUZC9x7t1q4RkIy6x4n8gXD")
            .queryParam("limit", 10)  // Add the 'limit' query parameter
            .when()
            .get("/breeds")
            .then()
            .statusCode(200)  // Assert that the status code is 200 (OK)
            .extract().response();

        // Print the response body for debugging
        System.out.println("Response Body: " + response.asString());

        // Validate the response fields
        response.then()
            // Validate the 'data' array is not empty
            .body("data.size()", greaterThan(0))  // Ensures that 'data' array has more than 0 elements

            // Validate the 'total' is 98
            .body("total", equalTo(98))

            // Validate the pagination fields
            .body("current_page", equalTo(1))
            .body("first_page_url", equalTo("https://catfact.ninja/breeds?page=1"))
            .body("last_page_url", equalTo("https://catfact.ninja/breeds?page=10"))
            .body("next_page_url", equalTo("https://catfact.ninja/breeds?page=2"))
            .body("prev_page_url", equalTo(null))

            // Validate the breed names in the first page of the data (examples)
            .body("data[0].breed", equalTo("Abyssinian"))
            .body("data[1].breed", equalTo("Aegean"))
            .body("data[2].breed", equalTo("American Curl"))

            // Validate the links
            .body("links[0].label", equalTo("Previous"))
            .body("links[0].active", equalTo(false))
            .body("links[1].label", equalTo("1"))
            .body("links[1].active", equalTo(true))
            .body("links[10].label", equalTo("10"))
            .body("links[10].active", equalTo(false));

	}

}
