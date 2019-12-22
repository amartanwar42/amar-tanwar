package apiAutomation.clients.pet;

import apiAutomation.entity.pet.CreatePetRequest;
import apiAutomation.entity.pet.CreatePetResponse;
import apiAutomation.utility.PetStoreProperties;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import io.restassured.RestAssured;

public class PetClients {

    private static final Logger logger = LogManager.getLogger(PetClients.class);

    public CreatePetResponse createPet(CreatePetRequest createPetRequest){
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.useRelaxedHTTPSValidation();

        logger.info("Pet Create URL --- POST {}", PetStoreProperties.CREATE_PET_URL);

        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(createPetRequest)
                .post(PetStoreProperties.CREATE_PET_URL);

        logger.info("Pet Create Response --- ({}) {}",response.statusCode(),response.asString());

        CreatePetResponse createPetResponse = response.as(CreatePetResponse.class);
        createPetResponse.setStatusCode(response.getStatusCode());
        return createPetResponse;
    }

    public CreatePetResponse getPet(String petId){
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.useRelaxedHTTPSValidation();

        logger.info("Pet Get URL --- POST {}", PetStoreProperties.GET_PET_URL+petId);

        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(PetStoreProperties.CREATE_PET_URL+petId);

        logger.info("Pet Get Response --- ({}) {}",response.statusCode(),response.asString());

        CreatePetResponse createPetResponse = response.as(CreatePetResponse.class);
        createPetResponse.setStatusCode(response.getStatusCode());
        return createPetResponse;
    }

    public int deletePet(String petId){
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.useRelaxedHTTPSValidation();

        logger.info("Pet Delete URL --- POST {}", PetStoreProperties.DELETE_PET_URL+petId);

        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .delete(PetStoreProperties.DELETE_PET_URL+petId);

        logger.info("Pet Delete Response --- ({}) {}",response.statusCode(),response.asString());


        return response.statusCode();
    }

}
