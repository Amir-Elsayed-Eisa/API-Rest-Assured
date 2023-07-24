package endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.json.Json;
import pojo.Store;

public class StoreEndPoints {
    public static Response PlaceOrder(Store Details){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(Details)
                .when()
                .post(BaseRoutes.UserCreateOrderURL)
                ;
        return response;


    }
    public static Response GetOrderDetails(int orderId){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("orderId", orderId)
                .when()
                .get(BaseRoutes.UserGetOrderURL)
                ;
        return response;
    }
    public static Response DeleteOrder(int orderId){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("orderId", orderId)
                .when()
                .delete(BaseRoutes.UserDeleteOrderURL);
        return response;
    }
    public static Response StoreInventory(){
        Response response = given()
                .when()
                .get(BaseRoutes.UserInventoryURL)
                ;
        return response;
    }

}
