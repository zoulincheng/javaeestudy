drop  database IF EXISTS itat_msg;
create database itat_msg;
use itat_msg;

create table t_user(
	id int(10) primary key auto_increment,
	username varchar(100),
	password varchar(100),
	nickname varchar(100),
	status int(2),
	type int(2)
);

GRANT ALL ON itat_msg.* to 'itat'@'localhost' IDENTIFIED BY 'itat123';
