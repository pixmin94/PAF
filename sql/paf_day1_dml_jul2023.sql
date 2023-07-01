/*
create database test;

use test;
*/

use paf_jul2023;

/*
insert into customer (first_name, last_name) values ('Swee Kiat', 'Heng');
insert into customer (first_name, last_name) values ('Desmond', 'Koh');
insert into customer (first_name, last_name) values ('Chan Meng', 'Khong');
insert into customer (first_name, last_name) values ('Lawrence', 'Khong');
insert into customer (first_name, last_name) values ('Lawrence', 'Wong');
insert into customer (first_name, last_name) values ('Kee Teck', 'Wong');
insert into customer (first_name, last_name) values ('Hsien Loong', 'Lee');
insert into customer (first_name, last_name) values ('Derrick', 'Lee');
insert into customer (first_name, last_name) values ('Josephine', 'Teo');
insert into customer (first_name, last_name) values ('Chee Hean', 'Teo');

-- 'single', 'standard', 'double', 'deluxe', 'prestige', 'president', 'suite'
insert into room (room_type, price) values ('single', 50);
insert into room (room_type, price) values ('standard', 100);
insert into room (room_type, price) values ('double', 150);
insert into room (room_type, price) values ('deluxe', 200);
insert into room (room_type, price) values ('prestige', 250);
insert into room (room_type, price) values ('president', 300);
insert into room (room_type, price) values ('suite', 350);

insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
values (1, 1, '2023-07-01', '2023-07-02', 100);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
values (2, 2, '2023-07-11', '2023-07-13', 300);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
values (3, 3, '2023-07-05', '2023-07-08', 450);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
values (4, 2, '2023-07-12', '2023-07-13', 300);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
values (5, 2, '2023-07-14', '2023-07-15', 300);
*/

select * from customer;

select * from customer limit 5;

select id, first_name, last_name from customer limit 2;

select id, first_name, last_name from customer limit 2 offset 4;

select * from customer where last_name = 'wong';

select * from customer where last_name like '%on%';

select * from reservation;

select * from reservation where start_date > '2023-07-01' and start_date < '2023-07-05';

select * from reservation where start_date between '2023-07-01' and '2023-07-05';

select * from reservation where start_date not between '2023-07-01' and '2023-07-05';

select * from room where room_type in ('single', 'double', 'prestige');

select * from reservation 
where 
customer_id > 2 
or
start_date between '2023-07-06' and '2023-07-10';


select id, first_name, last_name from customer;

select count(*) from room;



