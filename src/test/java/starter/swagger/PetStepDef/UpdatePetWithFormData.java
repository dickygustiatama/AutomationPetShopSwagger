package starter.swagger.PetStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.swagger.PetAPI;
import starter.swagger.Utils.Constant;
import starter.swagger.Utils.SwaggerResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdatePetWithFormData {
    @Steps
    PetAPI petAPI;

    @Given("Base URL for update pet with valid parameter {string}, name as {string} and status as {string}")
    public void baseURLForUpdatePetWithValidParameterAndForm(String petId, String name, String status) {
        petAPI.setPostUpdatePet(petId,name,status);
    }

    @When("Send request post update pet")
    public void sendRequestPostUpdatePet() {
        SerenityRest.when().post(PetAPI.POST_UPDATE_PET);
    }

    @And("Response body message should be the same as id {string}")
    public void responseBodyMessageShouldBeTheSameAsId(String id) {
        SerenityRest.then().body(SwaggerResponses.MESSAGE,equalTo(id));
    }

    @And("Validate json schema update pet")
    public void validateJsonSchemaUpdatePet() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/PetSchema/UpdatePetWithFormDataSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}
