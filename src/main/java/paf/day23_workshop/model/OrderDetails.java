package paf.day23_workshop.model;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class OrderDetails implements Serializable {
    private int id;
    private DateTime orderDate;
    private int customerID;
    private double totalPrice;
    private double discountedPrice;
    private double costPrice;

    public static OrderDetails create(SqlRowSet rs) {
        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setId(rs.getInt("order_id"));
        orderDetails.setOrderDate(new DateTime(DateTimeFormat.forPattern("dd/MM/yyyy")
                                                .parseDateTime(rs.getString("order_date"))));
        orderDetails.setCustomerID(rs.getInt("customer_id"));
        orderDetails.setTotalPrice(rs.getDouble("total_price"));
        orderDetails.setDiscountedPrice(rs.getDouble("discounted_price"));
        orderDetails.setCostPrice(rs.getDouble("cost_price"));

        return orderDetails;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("order_id", id)
                .add("order_date", orderDate.toString("dd/MM/yyyy"))
                .add("customer_id", customerID)
                .add("total_price", totalPrice)
                .add("discounted_price", discountedPrice)
                .add("cost_price", costPrice)
                .build();
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public DateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(DateTime orderDate) {
        this.orderDate = orderDate;
    }
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public double getDiscountedPrice() {
        return discountedPrice;
    }
    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
    public double getCostPrice() {
        return costPrice;
    }
    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }
}
