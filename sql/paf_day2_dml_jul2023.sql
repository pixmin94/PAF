use northwind;

select * 
from customers
where job_title = 'Purchasing Representative' 
or company = 'Company D';

select job_title, city 
from customers
where city = 'Seattle';

select count(*) 
from customers 
where city = 'Seattle';

select * from customers;

select avg(shipping_fee) 
from orders 
where customer_id = 6;

select first_name, last_name, 
length(first_name) as fname_length, length(last_name) as lname_length
from customers;

select sum(shipping_fee) as total_shipping_fee
from orders 
where customer_id = 6;


select customer_id, avg(shipping_fee)
from orders
group by customer_id
order by avg(shipping_fee) desc;

select order_id, product_id, quantity, unit_price, (quantity * unit_price) as cost
from order_details;

select order_id, sum(quantity * unit_price) as total_order_cost
from order_details
group by order_id
having sum(quantity * unit_price) >= 2000
order by total_order_cost desc;

select order_id, sum(quantity * unit_price) as total_order_cost
from order_details
group by order_id
having total_order_cost >= 2000
order by total_order_cost desc;

select last_name , first_name, 
concat(last_name, ' ', first_name) as full_name
from customers;


use paf_jul2023;

insert into tv_shows (prog_id, title, lang, rating, user_rating, release_date)
values (1, 'Transformers', 'English', 'PG', 7.0, '2023-06-06');
insert into tv_shows (prog_id, title, lang, rating, user_rating, release_date)
values (2, 'Top Gun Maverick', 'English', 'PG', 8.0, '2021-05-06');
insert into tv_shows (prog_id, title, lang, rating, user_rating, release_date)
values (3, 'Top Gun', 'English', 'PG', 9.0, '2012-05-06');

delete from reservation;

delete from room;

delete from customer;

/*
alter table reservation AUTO_INCREMENT = 1;

alter table customer AUTO_INCREMENT = 1;

alter table room AUTO_INCREMENT = 1;
*/

/*
create table rsvp (
	id int not null auto_increment,
    full_name varchar(200) not null,
    email varchar(100) not null,
    phone int,
    confirmation_date date, 
    comments text,
    constraint pk_rsvp_id primary key (id)
);
*/

select * from rsvp;


