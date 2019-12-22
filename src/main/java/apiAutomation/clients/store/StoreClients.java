package apiAutomation.clients.store;

import apiAutomation.entity.store.CreateStoreRequest;
import apiAutomation.entity.store.CreateStoreResponse;
import apiAutomation.utility.PetStoreProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class StoreClients {

    private static final Logger logger = LogManager.getLogger(StoreClients.class);

    public CreateStoreResponse createStore(CreateStoreRequest createStoreRequest){
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.useRelaxedHTTPSValidation();

        logger.info("Store Create URL --- POST {}", PetStoreProperties.CREATE_STORE_URL);

        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(createStoreRequest)
                .post(PetStoreProperties.CREATE_STORE_URL);

        logger.info("Store Create Response --- ({}) {}",response.statusCode(),response.asString());

        CreateStoreResponse createPetResponse = response.as(CreateStoreResponse.class);
        createPetResponse.setStatusCode(response.getStatusCode());
        return createPetResponse;
    }

    public CreateStoreResponse getStore(String orderId){
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.useRelaxedHTTPSValidation();

        logger.info("Store Get URL --- POST {}", PetStoreProperties.GET_STORE_URL+orderId);

        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(PetStoreProperties.GET_STORE_URL+orderId);

        logger.info("Store Get Response --- ({}) {}",response.statusCode(),response.asString());

        CreateStoreResponse createPetResponse = response.as(CreateStoreResponse.class);
        createPetResponse.setStatusCode(response.getStatusCode());
        return createPetResponse;
    }

    public int deleteStore(String orderId){
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.useRelaxedHTTPSValidation();

        logger.info("Store Delete URL --- POST {}", PetStoreProperties.DELETE_PET_URL+orderId);

        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .delete(PetStoreProperties.DELETE_PET_URL+orderId);

        logger.info("Store Delete Response --- ({}) {}",response.statusCode(),response.asString());

        return response.getStatusCode();
    }
}
