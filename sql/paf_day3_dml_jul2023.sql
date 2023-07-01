use paf_jul2023;

create table episodes (
	id		 	 int not null auto_increment,
    season   	 int not null,
    episode  	 int not null,
    title 	 	 varchar(255),
    sypnosis 	 text,
    release_date date not null,
    prog_id		 int not null,
    constraint pk_episode_id primary key (id),
    constraint fk_episodes_tvshows_id foreign key (prog_id) references tv_shows(prog_id)
);

select * from room;

select * from customer;

select * from reservation;

select r.*, c.first_name, c.last_name 
from reservation as r 
inner join customer as c on r.customer_id = c.id;

select r.*, c.first_name, c.last_name, rm.room_type, rm.price 
from reservation as r 
inner join customer as c on r.customer_id = c.id
inner join room as rm on r.room_id = rm.id;

select c.*, resv.*
from customer as c
left join reservation as resv on c.id = resv.customer_id;

select resv.*, c.*
from reservation as resv
right join customer as c on resv.customer_id = c.id;

create view reservation_details as 
select r.*, c.first_name, c.last_name, rm.room_type, rm.price 
from reservation as r 
inner join customer as c on r.customer_id = c.id
inner join room as rm on r.room_id = rm.id;

select * from reservation_details;

create table customer (
	id			int not null auto_increment,
    fullname 	varchar(200),
    constraint pk_customer_id primary key(id)
);

create table contact (
	id 			int not null auto_increment,
    fullname	varchar(200),
	constraint pk_contact_id primary key (id)
);

create table account_manager (
	id			int not null auto_increment,
    fullname	varchar(200),
    constraint pk_account_manager_id primary key (id)
);

create table customer_contact (
	customer_id	int not null,
    contact_id	int not null,
    constraint fk_customer_contact_customer_id foreign key (customer_id) references customer(id),
    constraint fk_customer_contact_contact_id foreign key (contact_id) references contact(id)
);

create table customer_account (
	customer_id	int not null,
    account_id 	int not null,
    constraint fk_customer_account_customer_id foreign key (customer_id) references customer(id),
    constraint fk_customer_account_account_id foreign key (account_id) references account_manager(id)
)

select * from customer
where last_name in ('Lee', 'Teo');

select distinct last_name from customer
where last_name = 'Lee' or last_name = 'Teo';

select * from customer
where last_name in 
(select distinct last_name from customer
where last_name = 'Lee' or last_name = 'Teo');



use northwind;

select * from invoices;

select * from orders;

select * from order_details;

select * from customers 
where company in ('Company A', 'Company B', 'Company C');

select * from orders 
where customer_id in (
	select id from customers 
	where company in ('Company A', 'Company B', 'Company C')
);


select id from customers 
where state_province in ('WA', 'MA', 'CA', 'NY', 'MN', 'WI');

select * from orders 
where customer_id in (
	select id from customers 
	where state_province in ('WA', 'MA', 'CA', 'NY', 'MN', 'WI')
);

select concat(emp.first_name, ' ', emp.last_name) as full_name, ord.* from orders as ord
inner join employees as emp 
on ord.employee_id = emp.id 
where customer_id in (
	select id from customers 
	where state_province in ('WA', 'MA', 'CA', 'NY', 'MN', 'WI') 
);

select * from
(
	select id from customers 
	where state_province in ('WA', 'MA', 'CA', 'NY', 'MN', 'WI') 
) as customer_unique_id;


select id, order_id, product_id, quantity, unit_price, discount, 
(quantity * unit_price * if(discount > 0, discount, 1)) as total_price 
from order_details





