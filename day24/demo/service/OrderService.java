package sg.iss.day24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.day24.model.Order;
import sg.iss.day24.model.OrderDetails;
import sg.iss.day24.repo.OrderDetailsRepo;
import sg.iss.day24.repo.OrderRepo;

@Service
public class OrderService {
    
    @Autowired
    OrderRepo ordRepo;

    @Autowired
    OrderDetailsRepo ordDetailsRepo;

    // @Transactional
    public Boolean makeOrder(Order order, List<OrderDetails> details) {

        // 1. create the order and get the returned pk of the created order
        Integer iCreatedOrderID = ordRepo.insertOrder(order);

        // 2. set the fk for the order details that linked to the created order
        for (OrderDetails od: details) {
            od.setOrderId(iCreatedOrderID);
        }

        // 3. create the order details
        // int [] iAdded = ordDetailsRepo.add(details);
        ordDetailsRepo.add(details);

        return true;
    }
}
