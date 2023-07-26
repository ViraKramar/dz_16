package tests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBookingResponse {
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
    private Integer bookingid;
}
