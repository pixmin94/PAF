package sg.iss.day24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.iss.day24.payload.OrderRequest;
import sg.iss.day24.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    OrderService ordSvc;

    @PostMapping
    public ResponseEntity<Boolean> createOrder(@RequestBody OrderRequest ordReq) {

        System.out.println("OrderController > createOrder >" + ordReq.toString());

        Boolean iResult = ordSvc.makeOrder(ordReq.getOrder(), ordReq.getOrderdetails());
        
        return ResponseEntity.ok().body(iResult);
    }
}