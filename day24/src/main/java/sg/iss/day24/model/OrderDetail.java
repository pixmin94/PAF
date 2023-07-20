package sg.iss.day24.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    private Integer id;

    private String product;

    private float unitPrice;

    private float discount;

    private Integer quantity;
}
