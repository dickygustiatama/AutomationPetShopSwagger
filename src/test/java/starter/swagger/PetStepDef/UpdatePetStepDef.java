package starter.swagger.PetStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.swagger.PetAPI;
import starter.swagger.Utils.Constant;

import java.io.File;

public class UpdatePetStepDef {

    @Steps
    PetAPI petAPI ;
    @Given("Put update pet with valid id")
    public void putUpdatePetWithValidId() {
        File json = new File(Constant.JSON_REQUEST+"/Pet/updatePetValidId.json");
        petAPI.putUpdatePet(json);

    }

    @When("Send request put update pet by ID")
    public void sendRequestPutUpdatePetByID() {
        SerenityRest.when().put(PetAPI.PUT_UPDATE_PET);
    }

    @And("Validate json schema update pet")
    public void validateJsonSchemaUpdatePet() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/PetSchema/PutUpdatePetSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema)) ;
    }

    @Given("Put update pet with invalid ID")
    public void putUpdatePetWithInvalidID() {
        File json = new File(Constant.JSON_REQUEST+"/Pet/updatePetInvalidId.json");
        petAPI.putUpdatePet(json);
    }

    @Given("Put update pet with unregistered ID")
    public void putUpdatePetWithUnregisteredID() {
        File json = new File(Constant.JSON_REQUEST+"/Pet/updateUnregisteredId.json");
        petAPI.putUpdatePet(json);
    }
}
