package paf.day23_workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paf.day23_workshop.model.OrderDetails;
import paf.day23_workshop.repo.OrderRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    public OrderDetails getOrderDetailsWDiscount(int orderID) {
        return orderRepo.getOrderDetailsWDiscount(orderID);
    }
}
