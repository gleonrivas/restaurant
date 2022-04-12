CREATE table employee (
id int(10) auto_increment not null,
name varchar(25) not null,
surname varchar(50) not null,
address varchar(100) not null,
phone int(9) not null,
dni varchar(9) not null,
employee_type varchar(20) not null,
primary key (id)
);

CREATE table product (
id int(10) auto_increment not null,
typo varchar(25) not null,
description varchar(25) not null,
code int(10) not null,
price double not null,
primary key (id)
);

CREATE table orders (
id int(10) auto_increment not null,
code varchar(5) not null,
capacity int(1) not null,
id_employee int(10) not null,
primary key(id),
constraint fk_orders_1 foreign key (id_employee) references employee(id)
);

CREATE table product_orders (
quantity int(20) not null,
id_orders int(10),
id_product int(10),
constraint fk_product_orders_1 foreign key (id_orders) references orders(id),
constraint fk_product_order_2 foreign key (id_product) references product(id)
);

CREATE table tables (
id int(10) auto_increment not null, 
location int(2) not null,
availability bool,
capacity int(3) not null,
id_employee int(10),
id_orders int(10),
primary key (id),
constraint fk_tables_1 foreign key (id_employee) references employee(id),
constraint fk_tables_2 foreign key (id_orders) references orders(id)
);


DROP table tables ;
DROP table product_orders ;
DROP table orders ;
DROP table product ;
DROP table employee ;

SELECT * FROM employee e ;
DELETE FROM employee;

