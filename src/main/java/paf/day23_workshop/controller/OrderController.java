package paf.day23_workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paf.day23_workshop.model.OrderDetails;
import paf.day23_workshop.service.OrderService;

@RestController
@RequestMapping(path = "/api/order-details", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    private OrderService orderSvc;

    @GetMapping("/{orderID}")
    public ResponseEntity<String> getOrderDetailsWDiscount(@PathVariable int orderID) {
        OrderDetails ord = orderSvc.getOrderDetailsWDiscount(orderID);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ord.toJson().toString());
    }
}
