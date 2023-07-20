package sg.iss.day24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.day24.repository.OrderRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import sg.iss.day24.model.Order;


@Controller
@RequestMapping
public class OrderController {
    @Autowired
    private OrderRepository repo;

    @GetMapping(path="/")
    public String getIndex() {
        return "order-form";
    }

    @PostMapping(path="/order")
    public ModelAndView createOrder(@ModelAttribute Order order) { // @RequestBody MultiValueMap<String, String> payload
        // for (String field: payload.keySet())
		// 	System.out.printf("PAYLOAD: %s = %s\n", field, payload.getFirst(field));
		// System.out.printf("PAYLOAD: %s\n", payload);

        Integer result = repo.createOrder(order);
        ModelAndView mav = new ModelAndView();

        mav.setViewName("order-success");
        mav.addObject("orderID", result);
        mav.setStatus(HttpStatusCode.valueOf(200));
        
        return mav;
    }

}
