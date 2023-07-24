package endpoints;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import pojo.User;

public class UserEndPoints {
    public static Response createUser(User Details){
        Response response =
                given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(Details)
                .when()
                .post(BaseRoutes.UserPostURL)
                 ;
        return response;


    }
    public static Response UserDetails(String UserName){
        Response response =
                given()
                        .pathParams("username", UserName)
                        .when()
                        .get(BaseRoutes.UserDetailsURL)
                        ;
        return response;

    }
    public static Response UserEdit(String UserName, User Details){
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .pathParams("username", UserName)
                        .body(Details)
                        .when()
                        .put(BaseRoutes.UserUpdateURL)
                        ;

        return response;
    }
    public static Response UserIn(String UserName, String Password){
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)

                        .queryParams("username", UserName, "password", Password)
                        .when()
                        .get(BaseRoutes.UserLogInURL)
                ;
        return response;
    }
    public static Response UserOut(){
        Response response = given()
                .when()
                .get(BaseRoutes.UserLogOutURL)
                ;
        return response;
    }

    public static Response UserDelete(String UserName){
        Response response =
                given()
                        .pathParams("username", UserName)
                        .when()
                        .delete(BaseRoutes.UserDeleteURL)
                        ;
        return response;

    }



}
