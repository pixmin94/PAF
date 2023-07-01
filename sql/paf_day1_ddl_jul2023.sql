/*
create database paf_jul2023;
*/

use paf_jul2023;

/*
create table tv_shows (
	prog_id			int not null,
    title			char(64) not null,
	lang 			char(16) not null,
    official_site	varchar(256),
    rating 			enum('G', 'PG', 'NC16', 'M18', 'R21') not null,
    user_rating		float default '0.0',
    release_date	date,
    constraint pk_prog_id primary key (prog_id),
    constraint chk_user_rating check(user_rating between 0.0 and 10.0)
);
*/

create table room (
	id	int not null auto_increment,
    room_type enum('single', 'standard', 'double', 'deluxe', 'prestige', 'president', 'suite') not null,
    price int not null,
    constraint pk_room_id primary key(id)
);

create table customer (
	id int not null auto_increment,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    constraint pk_customer_id primary key(id)
);

create table reservation (
	id int not null auto_increment,
    customer_id int not null,
    room_id int not null,
    start_date date,
    end_date date,
    total_cost int not null,
    constraint pk_reservation_id primary key (id),
    constraint fk_reservation_customer_id foreign key (customer_id) references customer(id),
    constraint fk_reservation_room_id foreign key (room_id) references room(id)
);

    