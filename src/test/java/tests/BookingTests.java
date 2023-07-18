package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookingTests {

    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
    }
    @Test(description = "Testing booking creating: positive")
    public void bookingPostTest(){
        BookingDates bookingDates = new BookingDates();

        CreateBooking body = new CreateBooking.CreateBookingBuilder()
                .firstname("Jimmy")
                .lastname("Jackson")
                .totalprice(500)
                .depositpaid(true)
                .bookingdates(bookingDates.giveDates())
                .additionalneeds("Swimming in the pool")
                .build();

        Response response = RestAssured.given()
                .body(body)
                .post("/booking");

        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test(description = "Testing all booking getting: positive")
    public void bookingGetTest(){
        Response response = RestAssured.get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test(description = "Testing Total Price updating: positive")
    public void bookingChangePrice(){
        Auth someAuth = new Auth();
        String newToken = someAuth.auth();

        BookingData bookingData = new BookingData();
        Integer newId = bookingData.bookingGetID();
        ChangePrice body = new ChangePrice.ChangePriceBuilder()
                .totalprice(5555777)
                .build();

        Response changePrice = RestAssured.given()
                .cookie("token", newToken)
                .body(body)
                .patch("/booking/{id}", newId);

        changePrice.then().statusCode(200);
        changePrice.prettyPrint();
    }

    @Test(description = "Testing Full Name and Additional Needs updating: positive")
    public void bookingChangeAdditional(){
        Auth someAuth = new Auth();
        String newToken = someAuth.auth();

        BookingDates bookingDates = new BookingDates();
        BookingData bookingData = new BookingData();
        Integer newId = bookingData.bookingGetID();

        CreateBooking body = new CreateBooking.CreateBookingBuilder()
                .firstname("New Name")
                .lastname("New Surname")
                .totalprice(111)
                .depositpaid(true)
                .bookingdates(bookingDates.giveDates())
                .additionalneeds("New need: Resting all day")
                .build();

        Response changeAdditional= RestAssured.given().log().all()
                .header("Accept", "application/json")
                .cookie("token", newToken)
                .body(body)
                .put("/booking/{{id}}", newId);

        changeAdditional.then().statusCode(200);
        changeAdditional.prettyPrint();
    }

    @Test(description = "Testing booking deleting: positive")
    public void bookingDelete(){
        Auth someAuth = new Auth();
        String newToken = someAuth.auth();

        BookingData bookingData = new BookingData();
        Integer newId = bookingData.bookingGetID();

        Response changePrice = RestAssured.given()
                .cookie("token", newToken)
                .delete("/booking/{id}", newId);

        changePrice.then().statusCode(201);
        changePrice.prettyPrint();
    }

}
