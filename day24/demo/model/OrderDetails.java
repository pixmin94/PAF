package sg.iss.day24.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    private Integer id;

    private String product;

    private Float unitPrice;

    private Float discount;

    private Integer quantity;

    private Integer orderId;
}
