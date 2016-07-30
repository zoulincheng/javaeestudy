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

create table t_msg(
	id int(10) primary key auto_increment,
	title varchar(255),
	content text,
	post_date datetime,
	user_id int(10),
	CONSTRAINT FOREIGN KEY (user_id) REFERENCES t_user(id)
);

create table t_comment(
	id int(10) primary key auto_increment,
	content text,
	post_date datetime,
	user_id int(10),
	msg_id int(10),
	CONSTRAINT FOREIGN KEY (user_id) REFERENCES t_user(id),
	CONSTRAINT FOREIGN KEY (msg_id) REFERENCES t_msg(id)
);

GRANT ALL ON itat_msg.* to 'itat'@'localhost' IDENTIFIED BY 'itat123';
