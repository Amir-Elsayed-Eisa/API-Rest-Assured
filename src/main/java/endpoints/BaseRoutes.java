package endpoints;

public class BaseRoutes {
    // PetStore Base URL
    public static String BaseURL = "https://petstore.swagger.io/v2";

    //User Model URL
    public static String UserPostURL = BaseURL+"/user";
    public static String UserDetailsURL = BaseURL+"/user/{username}";
    public static String UserUpdateURL = BaseURL+"/user/{username}";
    public static String UserLogInURL = BaseURL+"/user/login";
    public static String UserLogOutURL = BaseURL+"/user/logout";
    public static String UserDeleteURL = BaseURL+"/user/{username}";
    public static String UserCreateOrderURL = BaseURL+"/store/order";
    public static String  UserGetOrderURL = BaseURL+"/store/order/{orderId}";
    public static String UserDeleteOrderURL = BaseURL+"/store/order/{orderId}";
    public static String UserInventoryURL = BaseURL+"/store/inventory";



}
