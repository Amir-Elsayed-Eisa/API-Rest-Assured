package apitestcases;

import com.github.javafaker.Faker;
import endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.User;

import static org.hamcrest.Matchers.*;

public class UserTestC {
    Faker faker;
    User Details;
    UserEndPoints EPOBJ;
    @BeforeClass
    public void GenerateUserData(){
        faker = new Faker();
        Details = new User();
        Details.setId(faker.idNumber().hashCode());
        Details.setUsername(faker.name().username());
        Details.setFirstname(faker.name().firstName());
        Details.setLastname(faker.name().lastName());
        Details.setEmail(faker.internet().emailAddress());
        Details.setPassword(faker.internet().password());
        Details.setPhone(faker.phoneNumber().cellPhone());

    }
    @Test(priority = 1)
    public void CreateUserTC(){

        Response response = EPOBJ.createUser(Details);
        response.then().log().all()
                .assertThat().statusCode(200);


    }
    @Test(priority = 2)
    public void GetUserDetails(){
        Response response = EPOBJ.UserDetails(this.Details.getUsername());
        response.then().log().all().assertThat().statusCode(200);


    }
    @Test(priority = 3)
    public void UpdateUserDetails(){

        Details.setUsername("AmirEisa");

        Details.setEmail("fake@example.com");
        Details.setPassword(faker.internet().password());
        Details.setPhone(faker.phoneNumber().cellPhone());

        Response response = EPOBJ.UserEdit(this.Details.getUsername(), Details);
        response.then().log().all().assertThat().statusCode(200);

    }
    @Test(priority = 4)
    public void GetUserAfterEdit(){
        Response response = EPOBJ.UserDetails(this.Details.getUsername());
        response.then().log().all().assertThat().statusCode(200)
                .assertThat().body("username", equalTo("AmirEisa")
                ,"email", equalTo("fake@example.com"),
                        "phone", is(not(empty())));


    }
    @Test(priority = 6)
    public void UserLoginSuccessfully(){
        Response response = EPOBJ.UserIn(this.Details.getUsername(), Details.getPassword());
        response.then().log().all().assertThat().statusCode(200);

    }
    @Test(priority = 5)
    public void UserLogOutSuccessfully(){
        Response response = EPOBJ.UserOut();
        response.then().log().all().assertThat().statusCode(200);
    }
    @Test(priority = 7)
    public void DeleteUserSuccessfully(){
        Response response = EPOBJ.UserDelete(this.Details.getUsername());
        response.then().log().all().assertThat().statusCode(200);
    }




}
