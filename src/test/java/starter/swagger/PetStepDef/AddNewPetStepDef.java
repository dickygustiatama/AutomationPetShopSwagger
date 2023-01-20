package starter.swagger.PetStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.swagger.PetAPI;
import starter.swagger.Utils.Constant;

import java.io.File;

public class AddNewPetStepDef {
    @Steps
    PetAPI petAPI;
    @Given("Base URL for new pet with valid and complete body")
    public void baseURLForNewPetWithValidAndCompleteBody() {
        File json = new File(Constant.JSON_REQUEST + "/Pet/requestPet.json");
        petAPI.postNewPet(json);
    }

    @And("Send request post add new pet")
    public void sendRequestPostAddNewPet() {
        SerenityRest.when().post(PetAPI.POST_NEW_PET);
    }
}
