package starter.swagger.PetStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.swagger.PetAPI;
import starter.swagger.Utils.Constant;

import java.io.File;

public class NewPetStepDef {
    @Steps
    PetAPI petAPI ;
    @Given("Post create new pet with valid json")
    public void postCreateNewPetWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/Pet/requestPet.json");
        petAPI.postNewPet(json);

    }

    @When("send request post create new pet")
    public void sendRequestPostCreateNewPet() {
        SerenityRest.when().post(PetAPI.POST_NEW_PET) ;
    }

//    @Then("Should return status code {int}")
//    public void shouldReturnStatusCode(int statusCode) {
//        SerenityRest.then().statusCode(statusCode);
//    }

    @And("Validate json schema create new pet")
    public void validateJsonSchemaCreateNewPet() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/PetSchema/addPetSchema.json") ;
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema)) ;
    }

    @Given("Post create new pet without ID")
    public void postCreateNewPetWithoutID() {
        File json = new File(Constant.JSON_REQUEST+"/Pet/petWithoutID.json");
        petAPI.postNewPet(json);
    }

    @Given("Post create new pet without name")
    public void postCreateNewPetWithoutName() {
        File json = new File(Constant.JSON_REQUEST+"/Pet/petWithoutName.json");
        petAPI.postNewPet(json);
    }

    @Given("Post create new pet without photoUrls")
    public void postCreateNewPetWithoutPhotoUrls() {
        File json = new File(Constant.JSON_REQUEST+"/Pet/petWithoutPhoto.json");
        petAPI.postNewPet(json);
    }

    @Given("Post create new pet without tags")
    public void postCreateNewPetWithoutTags() {
        File json = new File(Constant.JSON_REQUEST+"/Pet/petWithoutTags.json");
        petAPI.postNewPet(json);
    }

    @Given("Post create new pet without status")
    public void postCreateNewPetWithoutStatus() {
        File json = new File(Constant.JSON_REQUEST+"/Pet/petWithoutStatus.json");
        petAPI.postNewPet(json);
    }

    @Given("Post create new pet with invalid data type ID")
    public void postCreateNewPetWithInvalidDataTypeID() {
        File json = new File(Constant.JSON_REQUEST+"/Pet/petInvalidId.json");
        petAPI.postNewPet(json);
    }

    @Given("Post create new pet with empty JSON in body")
    public void postCreateNewPetWithEmptyJSONInBody() {
        File json = new File(Constant.JSON_REQUEST+"/Pet/Empty.json");
        petAPI.postNewPet(json);
    }

    @Given("Post create new pet with null JSON in body")
    public void postCreateNewPetWithNullJSONInBody() {
        File json = new File(Constant.JSON_REQUEST+"/Pet/null.json");
        petAPI.postNewPet(json);
    }
}
