package starter.swagger.PetStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.swagger.PetAPI;
import starter.swagger.Utils.Constant;

import java.io.File;

public class GetPetStepDef {
    @Steps
    PetAPI petAPI ;
    @Given("Get pet id {int}")
    public void getPetId(int id) {
        petAPI.getPetID(id);
    }

    @When("Send request get pet")
    public void sendRequestGetPet() {
        SerenityRest.when().get(PetAPI.GET_PET_ID);
    }

    @And("Validate json schema find pet with ID")
    public void validateJsonSchemaFindPetWithID() {
        File json = new File(Constant.JSON_SCHEMA+"/PetSchema/GetPetID.json");
        petAPI.postNewPet(json);
    }

    @Given("Get pet invalid id {string}")
    public void getPetId(String id) {
        petAPI.getPetInvalidID(id);
    }


    @Given("Get find pet without body")
    public void getFindPetWithoutBody() {
        SerenityRest.when().get(PetAPI.GET_PET_NULL_ID) ;
    }

    //Get by status
    @Given("Get find pet with status {string}")
    public void getFindPetWithStatus(String status) {
        petAPI.getPetStatus(status);
    }

    @When("Send request get pet with status")
    public void sendRequestGetPetWithStatus() {
        SerenityRest.when().get(PetAPI.GET_PET_STATUS);
    }


    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}
