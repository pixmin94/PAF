create table BankAccount (
	id int not null auto_increment,
	full_name varchar(200),
    is_blocked boolean,
	is_active boolean,
    account_type varchar(20)
    balance numeric(7,2),
    constrain pk_bankaccount_id primary key (id)
);