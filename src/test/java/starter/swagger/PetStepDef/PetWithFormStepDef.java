package starter.swagger.PetStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.swagger.PetAPI;
import starter.swagger.Utils.SwaggerResponses;

public class PetWithFormStepDef {
    PetAPI petAPI;
    @Given("Base URL for update pet with valid parameter {string}, name as {string} and status as {string}")
    public void baseURLForUpdatePetWithValidParameterNameAsAndStatusAs(String id, String name, String status) {
        petAPI.setPostUpdatePet(id,name,status);
    }

    @When("Send request post update pet")
    public void sendRequestPostUpdatePet() {
        SerenityRest.when().post(PetAPI.POST_UPDATE_PET) ;
    }


}
