package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.weatherbit.v2.comon.CommonData;
import net.serenitybdd.rest.SerenityRest;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetCurrentAirQualitySteps {

    public Response response;

    @Given("I send a get air quality request to weatherbit for post code {int}")
    public void sendRequestAirQualityWithPostCode(int postCode) throws IOException {
        response = SerenityRest.given()
                .baseUri(CommonData.URL)
                .basePath("/current/airquality")
                .param("postal_code", postCode)
                .param("key", CommonData.APIKey)
                .when().get();
    }

    @Then("Response should contain State code {string}")
    public void verifyResponseContentStateCode(String stateCode) {
        String outStateCode = response.jsonPath().getString("state_code");
        assertEquals(stateCode, outStateCode);
    }

    @Then("Response should contain Country code {string}")
    public void verifyResponseContentCountryCode(String countryCode) {
        String outCountryCode = response.jsonPath().getString("country_code");
        assertEquals(countryCode, outCountryCode);
    }

    @Then("the API should return status {int}")
    public void verifyResponse(int status) {
        SerenityRest.restAssuredThat(response -> response.statusCode(status));
    }
}
