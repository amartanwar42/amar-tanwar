package apiTest;

import apiAutomation.clients.store.StoreClients;
import apiAutomation.entity.store.CreateStoreRequest;
import apiAutomation.entity.store.CreateStoreResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StoreTests {
    StoreClients storeClients= new StoreClients();
    String storeId;

    @Test(groups = {"API"})
    public void createStore(){
        CreateStoreRequest createStoreRequest= new CreateStoreRequest();
        createStoreRequest.setId("111");
        createStoreRequest.setPetId("232244");
        createStoreRequest.setComplete("true");
        createStoreRequest.setQuantity("8");
        createStoreRequest.setShipDate("2019-12-22T05:59:23.181Z");
        createStoreRequest.setStatus("approved");

        CreateStoreResponse store = storeClients.createStore(createStoreRequest);
        storeId=store.getId();
        Assert.assertEquals(store.getStatusCode(),200);

    }

    @Test(groups = {"API"},dependsOnMethods = {"createStore"})
    public void getStore(){
        CreateStoreResponse store = storeClients.getStore(storeId);
        Assert.assertEquals(store.getStatusCode(),200);
    }

    @Test(groups = {"API"},dependsOnMethods = {"getStore"})
    public void deleteStore(){
        int i = storeClients.deleteStore(storeId);
        Assert.assertEquals(i,200);
    }

}
