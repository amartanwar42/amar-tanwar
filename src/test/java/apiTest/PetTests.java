package apiTest;

import apiAutomation.clients.pet.PetClients;
import apiAutomation.entity.pet.CreatePetRequest;
import apiAutomation.entity.pet.CreatePetResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetTests {

    PetClients petClients = new PetClients();
    String petId;

    @Test(groups = {"API"})
    public void createPet(){
        CreatePetRequest createPetRequest= new CreatePetRequest();
        createPetRequest.setId("10");
        createPetRequest.setPetId("30293");
        createPetRequest.setQuantity("7");
        createPetRequest.setShipDate("2019-12-22T05:59:23.181Z");
        createPetRequest.setComplete("true");
        createPetRequest.setStatus("approved");


        CreatePetResponse pet = petClients.createPet(createPetRequest);
        petId=pet.getId();
        Assert.assertEquals(pet.getStatusCode(),200);
    }

    @Test(groups = {"API"},dependsOnMethods = {"createPet"})
    public void getPet(){
        CreatePetResponse pet = petClients.getPet(petId);
        Assert.assertEquals(pet.getStatusCode(),200);
    }

    @Test(groups = {"API"},dependsOnMethods = {"getPet"})
    public void deletePet(){
        int pet = petClients.deletePet(petId);
        Assert.assertEquals(pet,200);
    }
}
