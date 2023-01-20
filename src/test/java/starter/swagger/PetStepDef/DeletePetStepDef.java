package starter.swagger.PetStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.swagger.PetAPI;

public class DeletePetStepDef {
    @Steps
    PetAPI petAPI ;
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdId(int id) {
        petAPI.deletePet(id);

    }

    @When("Send request delete pet")
    public void sendRequestDeletePet() {
        SerenityRest.when().delete(PetAPI.DELETE_PET_ID) ;
    }

    @Given("Delete user with unregistered id {int}")
    public void deleteUserWithUnregisteredId(int id) {
        petAPI.deletePet(id);
    }

    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        petAPI.deletePetInvalid(id);
    }
}
