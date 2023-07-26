package tests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDates {
    private String checkin;
    private String checkout;

    public BookingDates giveDates(){
        return BookingDates.builder()
                .checkin("2023-07-23")
                .checkout("2023-07-30")
                .build();
    }

}
