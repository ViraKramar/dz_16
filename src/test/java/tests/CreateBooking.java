package tests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBooking {
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
}

