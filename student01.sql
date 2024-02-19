drop database if exists student01;
create database if not exists student01;
use student01;

create table student(
	id int primary key auto_increment,
    name varchar(255),
    email varchar(255),
    address varchar(255)
);

insert into student
values (1, 'Huỳnh Dụng', 'thanhdung26031994@gmail.com', 'Quảng Ngãi'),
(2, 'Tấn Phát', 'vandat@gmail.com', 'Đà Nẵng'),
(3, 'Văn Đạt', 'vandat@gmail.com', 'Huế');

select *
from student;