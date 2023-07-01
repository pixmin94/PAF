package sg.iss.day24.payload;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.iss.day24.model.Order;
import sg.iss.day24.model.OrderDetails;

@Data
@NoArgsConstructor
public class OrderRequest {
    
    private Order order;

    private List<OrderDetails> orderdetails;
}