package starter.swagger.PetStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Fields;
import net.thucydides.core.annotations.Steps;
import starter.swagger.PetAPI;
import starter.swagger.Utils.Constant;

import java.io.File;

public class UploadImageStepDef {
    @Steps
    PetAPI petAPI;
    @Given("Base URL for upload an image with parameter {string}, additionalMetadata as {string}")
    public void baseURLForUploadAnImageWithValidParameterAndValidCompleteBody(String petId,String metadata) {
        File image = new File(Constant.IMAGE_REQUEST + "/gettyimages-553927883.webp");
        petAPI.setPostImagePet(petId,metadata,image);
    }

    @When("Send request post upload an image")
    public void sendRequestPostUploadAnImage() {
        SerenityRest.when().post(PetAPI.POST_IMAGE_PET);
    }

    @And("Validate json schema upload an image")
    public void validateJsonSchemaUploadAnImage() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/PetSchema/UploadImageSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Base URL for upload an image with parameter {string}, additionalMetadata as {string}, but without body")
    public void baseURLForUploadAnImageWithParameterAdditionalMetadataAsButWithoutBody(String petId, String metadata) {
        petAPI.setPostImagePetWithoutFile(petId,metadata);
    }
}
