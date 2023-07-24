package apitestcases;

import com.github.javafaker.Faker;
import endpoints.StoreEndPoints;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.Store;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

public class OrderTestC {
    Faker faker;
    Store Details;
    StoreEndPoints SEPOBJ;
    @BeforeClass
    public void GenerateOrderDetails(){
        faker = new Faker();
        Details = new Store();
        Details.setId(faker.idNumber().hashCode());
        Details.setPetId(faker.idNumber().hashCode());
        Details.setQuantity(faker.number().numberBetween(1, 5));
        Details.setShipDate("2024-06-11T14:31:57.294Z");
        Details.setStatus("Placed");
        Details.setComplete(faker.bool().bool());

    }
    @Test(priority = 1)
    public void MakingOrder(){
        Response response = SEPOBJ.PlaceOrder(Details);
        response.then().log().all().assertThat().statusCode(200);

    }
    @Test(priority = 2)
    public void OrderDetails(){
        Response response = SEPOBJ.GetOrderDetails(this.Details.getId());
        response.then().log().all().assertThat().statusCode(200)
                .body("quantity", is(not(empty())), "status", equalTo("Placed"), "", hasKey("id")
                        ,"", hasKey("petId"))
                ;

    }
    @Test(priority = 3)
    public void RemoveOrder(){
        Response response = SEPOBJ.DeleteOrder(this.Details.getId());
        response.then().log().all().assertThat().statusCode(200);

    }
    @Test(priority = 4)
    public void CheckInventory(){
        Response response = SEPOBJ.StoreInventory();
        response.then().log().all().assertThat().statusCode(200);
    }

}
