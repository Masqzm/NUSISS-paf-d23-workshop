use northwind;

select * from orders;
# shows table attributes
desc orders;

# order_id from order_details is fk on orders table
select * from order_details;
desc order_details;

select * from products;
desc products;

# TODO: order id with order details fk order_id
# TODO: order details join with prod id


select 
	o.id as order_id,
	DATE_FORMAT(o.order_date, '%d/%m/%Y') as order_date,
	o.customer_id as customer_id,
	SUM(od.quantity * od.unit_price)  as total_price,
	(SUM(od.quantity * od.unit_price) - SUM(od.quantity * od.unit_price * od.discount)) as discounted_price,
	SUM(od.quantity * p.standard_cost) as cost_price
from orders as o
inner join order_details as od
	on o.id = od.order_id
inner join products as p
	on od.product_id = p.id
where o.id = 30;
#group by o.id, o.order_date, o.customer_id;


# Creating users & granting permissions
create user 'fred'@'%'		# % is a wild card for any host
identified by 'qweasd';		# password

grant all privileges on northwind.* 
to 'fred'@'%';

flush privileges;
