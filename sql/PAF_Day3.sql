use paf_23;

select * from room;

select * from customer;

select * from reservation;


select r.*, c.first_name, c.last_name
from reservation as r 
inner join customer as c on r.customer_id = c.id;

-- using data from reservation and pulling the customer first name and last name from customer table
-- and room type and price from room table
select r.*, c.first_name, c.last_name, rm.room_type, rm.price
from reservation as r 
inner join customer as c on r.customer_id = c.id
inner join room as rm on r.room_id = rm.id;

-- left join, pull all customer details, and add resv if have, if not its null
select c.*, resv.*
from customer as c
left join reservation as resv on c.id = resv.customer_id;

select resv.*, c.*
from reservation as resv
right join customer as c on resv.customer_id = c.id;


-- like saving this query as a view, its cached can be accessed more easily 
-- but cannot be modified, no insert etc allowed
create view reservation_details as
select r.*, c.first_name, c.last_name, rm.room_type, rm.price
from reservation as r 
inner join customer as c on r.customer_id = c.id
inner join room as rm on r.room_id = rm.id;

select * from reservation_details;

create table customer (
	id int not null,
    fullname varchar(100),
    constraint pk_cust_id primary key (id)
);

create table account_manager (
	id int not null,
    fullname varchar(100),
	room varchar(100),
    constraint pk_account_manager_id primary key (id)
);

create table customer_account (
	customer_id int not null,
    account_manager_id int not null,
    constraint fk_customer_id foreign key (customer_id) references customer(id),
    constraint fk_acctmgr_id foreign key (account_manager_id) references account_manager(id)
);

select * from order_details;

select * from customers
where company in ('Company A', 'Company B', 'Company C');

-- able to filter sub query (filter in view?)
select * from customers
where customer_id in (
	select id from customers
    where company in ('Company A', 'Company B', 'Company C')
);