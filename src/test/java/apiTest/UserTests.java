package apiTest;

import apiAutomation.clients.user.UserClients;
import apiAutomation.entity.user.CreateUserRequest;
import apiAutomation.entity.user.CreateUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTests {
    UserClients userClients= new UserClients();
    String userName;

    @Test(groups = {"API"})
    public void createUser(){
        CreateUserRequest createUserRequest= new CreateUserRequest();
        createUserRequest.setEmail("amartanwar42@gmail.com");
        createUserRequest.setFirstName("amar");
        createUserRequest.setId("100");
        createUserRequest.setLastName("tanwar");
        createUserRequest.setPassword("amartanwar");
        createUserRequest.setPhone("+918088455751");
        createUserRequest.setUsername("amartanwar");
        createUserRequest.setUserStatus("1");

        CreateUserResponse user = userClients.createUser(createUserRequest);
        userName=user.getUsername();
        Assert.assertEquals(user.getStatusCode(),200);

    }

    @Test(groups = {"API"}, dependsOnMethods = {"createUser"})
    public void getUser(){
        CreateUserResponse user = userClients.getUser(userName);
        Assert.assertEquals(user.getStatusCode(),200);
    }

    @Test(groups = {"API"},dependsOnMethods = {"getUser"})
    public void deleteUser(){
        int i = userClients.deleteUser(userName);
        Assert.assertEquals(i,200);
    }

}
