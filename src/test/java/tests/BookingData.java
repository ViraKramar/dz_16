package tests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.*;
import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingData {

    private Integer bookingid;
    public Integer bookingGetID(){
        Response response = RestAssured.get("/booking");
        BookingId[] bookingIds = response.as(BookingId[].class);
        Integer myId = Arrays.stream(bookingIds).findAny().get().getBookingid();
        System.out.println(myId);
        return myId;
    }
}
