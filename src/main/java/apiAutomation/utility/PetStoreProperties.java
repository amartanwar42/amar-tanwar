package apiAutomation.utility;

public class PetStoreProperties {

    private static final PropertiesReader reader= new PropertiesReader();

    public static final String BASE_URL= reader.getPetStoreBaseUrl();

    //pet urls
    public static final String CREATE_PET_URL= String.format("%s/api/v3/pet",BASE_URL);
    public static final String GET_PET_URL= String.format("%s/pet/",BASE_URL);
    public static final String DELETE_PET_URL= String.format("%s/pet/",BASE_URL);

    //store urls
    public static final String CREATE_STORE_URL= String.format("%s/store/order",BASE_URL);
    public static final String GET_STORE_URL= String.format("%s/store/order/",BASE_URL);
    public static final String DELETE_STORE_URL= String.format("%s/store/order/",BASE_URL);

    //user urls
    public static final String CREATE_USER_URL= String.format("%s/api/v3/user",BASE_URL);
    public static final String GET_USER_URL= String.format("%s/user/",BASE_URL);
    public static final String DELETE_USER_URL= String.format("%s/user/",BASE_URL);


}
