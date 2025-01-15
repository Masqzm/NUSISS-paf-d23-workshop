package paf.day23_workshop.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import paf.day23_workshop.SQLQueries;
import paf.day23_workshop.model.OrderDetails;

@Repository
public class OrderRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OrderDetails getOrderDetailsWDiscount(int orderID) {
        final List<OrderDetails> orderDetails = new ArrayList<>();
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQLQueries.GET_ORDER_DETAILS_W_DISCOUNT, orderID);

        while(rs.next())
            orderDetails.add(OrderDetails.create(rs));

        return orderDetails.get(0);
    }
}
