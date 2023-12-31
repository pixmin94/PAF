package sg.iss.day24.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer orderId;

    private Date date;

    @NotEmpty(message = "Name is a mandatory field")
    private String customerName;

    @NotEmpty(message = "Address is a mandatory field")
    private String shipAddress;

    private String notes;

    private float tax;
}
