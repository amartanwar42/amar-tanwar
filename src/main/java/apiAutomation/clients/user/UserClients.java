package apiAutomation.clients.user;

import apiAutomation.entity.user.CreateUserRequest;
import apiAutomation.entity.user.CreateUserResponse;
import apiAutomation.utility.PetStoreProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class UserClients {

    private static final Logger logger = LogManager.getLogger(UserClients.class);

    public CreateUserResponse createUser(CreateUserRequest createUserRequest){
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.useRelaxedHTTPSValidation();

        logger.info("User Create URL --- POST {}", PetStoreProperties.CREATE_USER_URL);

        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(createUserRequest)
                .post(PetStoreProperties.CREATE_STORE_URL);

        logger.info("User Create Response --- ({}) {}",response.statusCode(),response.asString());

        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.getStatusCode());
        return createUserResponse;
    }

    public CreateUserResponse getUser(String userName){
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.useRelaxedHTTPSValidation();

        logger.info("User Get URL --- POST {}", PetStoreProperties.GET_USER_URL+userName);

        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(PetStoreProperties.GET_USER_URL+userName);

        logger.info("User Get Response --- ({}) {}",response.statusCode(),response.asString());

        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.getStatusCode());
        return createUserResponse;
    }

    public int deleteUser(String userName){
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.useRelaxedHTTPSValidation();

        logger.info("User Delete URL --- POST {}", PetStoreProperties.DELETE_USER_URL+userName);

        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .delete(PetStoreProperties.DELETE_USER_URL+userName);

        logger.info("User Delete Response --- ({}) {}",response.statusCode(),response.asString());

        return response.getStatusCode();
    }

}
