use northwind;

select * 
from customers
where
job_title = 'Purchasing Representative'
or
company = 'Company D';

select distince job_title, city
from customers
where city = 'Seattle';

select count(distinct job_title)
from customers
where city = 'Seattle';

select * from customer
;

select customer_id, avg(shipping_fee)
from orders
group by customer_id
order  by avg(shipping_fee) desc;

select order_id, product_id, quantity, unit_price, (quantity * unit_price) as cost
from order_details;

select order_id, sum(quantity * unit price) as total_order_cost
from order_details
group by order_id;

delete from reservation; 

delete from room;

delete from customer;

alter table reservation AUTO_INCREMENT = 1;

alter table customer AUTO_INCREMENT = 1;


alter table room AUTO_INCREMENT = 1;

create table rsvp (
	id int not null auto_increment,
    full_name varchar(200) not null, 
    email varchar(100) not null,
    phone int,
    confirmation_date date,
    comments text
    );

