package paf.day23_workshop;

public class SQLQueries {
    public static final String GET_ORDER_DETAILS_W_DISCOUNT = """
            SELECT
            	o.id as order_id,
            	DATE_FORMAT(o.order_date, '%d/%m/%Y') as order_date,
            	o.customer_id as customer_id,
            	SUM(od.quantity * od.unit_price)  as total_price,
            	(SUM(od.quantity * od.unit_price) - SUM(od.quantity * od.unit_price * od.discount)) as discounted_price,
            	SUM(od.quantity * p.standard_cost) as cost_price
            FROM orders as o
            LEFT JOIN order_details as od
            	on o.id = od.order_id
            LEFT JOIN products as p
            	on od.product_id = p.id
            WHERE o.id = ?
    """;
}
